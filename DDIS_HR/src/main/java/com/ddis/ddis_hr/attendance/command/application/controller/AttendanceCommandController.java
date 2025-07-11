package com.ddis.ddis_hr.attendance.command.application.controller;

import com.ddis.ddis_hr.attendance.command.application.dto.*;
import com.ddis.ddis_hr.attendance.command.application.service.AttendanceCommandService;
import com.ddis.ddis_hr.attendance.command.domain.aggregate.Meeting;
import com.ddis.ddis_hr.attendance.command.domain.aggregate.PersonalSchedule;
import com.ddis.ddis_hr.member.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceCommandController {

    private final AttendanceCommandService attendanceCommandService;

    // 출근 등록
    @PostMapping("/check-in")
    public ResponseEntity<String> checkIn(@AuthenticationPrincipal CustomUserDetails user) {
        attendanceCommandService.checkIn(user.getEmployeeId());
        return ResponseEntity.ok("출근이 정상적으로 등록되었습니다.");
    }

    // 퇴근 등록
    @PutMapping("/check-out")
    public ResponseEntity<String> checkOut(@AuthenticationPrincipal CustomUserDetails user) {
        attendanceCommandService.checkOut(user.getEmployeeId());
        return ResponseEntity.ok("퇴근이 정상적으로 등록되었습니다.");
    }

    // 개인 일정 등록
    @PostMapping("/schedule/personal")
    public ResponseEntity<PersonalScheduleResponseDTO> addPersonalSchedule(@RequestBody PersonalScheduleRequestDTO dto,
                                                                @AuthenticationPrincipal CustomUserDetails user) {
        Long employeeId = user.getEmployeeId();
        PersonalSchedule saved = attendanceCommandService.personalScheduleRegister(dto, employeeId);
        return ResponseEntity.ok(new PersonalScheduleResponseDTO(saved));
    }

    // 개인 일정 수정
    @PutMapping("/schedule/personal/{id}")
    public ResponseEntity<Void> updatePersonalSchedule(@PathVariable Long id,
                                                       @RequestBody PersonalScheduleRequestDTO dto) {
        attendanceCommandService.updatePersonalSchedule(id, dto);
        return ResponseEntity.ok().build();
    }

    // 개인 일정 삭제
    @DeleteMapping("/schedule/personal/{id}")
    public ResponseEntity<Void> deletePersonalSchedule(@PathVariable Long id) {
        attendanceCommandService.deletePersonalSchedule(id);
        return ResponseEntity.noContent().build();
    }


    // 회의 일정 등록
    @PostMapping("/schedule/meeting")
    public ResponseEntity<MeetingScheduleResponseDTO> addMeetingSchedule(@RequestBody MeetingScheduleRequestDTO dto,
                                                @AuthenticationPrincipal CustomUserDetails user) {
        Meeting saved = attendanceCommandService.MeetingScheduleRegister(dto, user.getEmployeeId(), user.getTeamId());
        return ResponseEntity.ok(new MeetingScheduleResponseDTO(saved));
    }

    // 회의 일정 수정
    @PutMapping("/schedule/meeting/{id}")
    public ResponseEntity<Void> updateMeetingSchedule(@PathVariable Long id,
                                                       @RequestBody MeetingScheduleRequestDTO dto) {
        attendanceCommandService.updateMeetingSchedule(id, dto);
        return ResponseEntity.ok().build();
    }

    // 회의 일정 삭제
    @DeleteMapping("/schedule/meeting/{id}")
    public ResponseEntity<Void> deleteMeetingSchedule(@PathVariable Long id) {
        attendanceCommandService.deleteMeetingSchedule(id);
        return ResponseEntity.noContent().build();
    }

    // 출근 정정 신청
    @PostMapping("/correction/request")
    public ResponseEntity<?> requestCorrection(
            @AuthenticationPrincipal CustomUserDetails user,
            @RequestBody AttendanceCorrectionRequestDTO dto) {

        attendanceCommandService.requestCorrection(user.getEmployeeId(), dto);
        return ResponseEntity.ok().build();
    }

    // 출근 정정 승인 (인사)
    @PreAuthorize("hasRole('ROLE_HR')")
    @PostMapping("/correction/approve")
    public ResponseEntity<Void> approveCorrection(@RequestBody AttendanceApproveRequestDTO dto) {
        attendanceCommandService.approveCorrection(dto.attendanceId());
        return ResponseEntity.ok().build();
    }

    // 출근 정정 반려 (인사)
    @PreAuthorize("hasRole('ROLE_HR')")
    @PostMapping("/correction/reject")
    public ResponseEntity<Void> rejectCorrection(@RequestBody AttendanceRejectRequestDTO dto) {
        attendanceCommandService.rejectCorrection(dto.attendanceId(), dto.rejectReason());
        return ResponseEntity.ok().build();
    }

    // 초과 근무 신청
    @PostMapping("/overtime-request")
    public ResponseEntity<Void> requestOvertime(@RequestBody OvertimeRequestDTO dto,
                                                @AuthenticationPrincipal CustomUserDetails user) {
        attendanceCommandService.handleOvertimeRequest(dto, user.getEmployeeId());
        return ResponseEntity.ok().build();
    }


}
