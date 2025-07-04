package com.ddis.ddis_hr.eapproval.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// 문서함 dto
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {

    private Long docId;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime submittedAt;
    private LocalDateTime approvedAt;
    private String docStatus;     // 문서 상태 ('심사중', '반려', '결재완료' 등)
    private String lineStatus;    // 사용자의 결재 상태 ('미결', '승인', '반려' 등)
    private String drafter;       // 기안자 이름
    private String drafterRank;   // 기안자 직급
    private String type;          // 양식 이름
    private String lineType;
    private String approverName;
    private String approverRank;


}