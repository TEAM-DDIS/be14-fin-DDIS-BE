package com.ddis.ddis_hr.eapproval.query.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReferenceDocDTO {
    private Long employeeId;
    private Long docId;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    private String employeeName;
    private boolean isRead;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime readAt;
    private String role;
    private String drafterName;
    private String drafterRank;
}
