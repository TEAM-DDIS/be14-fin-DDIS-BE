package com.ddis.ddis_hr.chatbot.command.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class TeamMemberDTO {
    String employeeName;
    Long departmentId;
    String departmentName;
    Long teamId;
    String teamName;
    Long positionId;
    String positionName;
    Long rankId;
    String rankName;
    String jobName;
    LocalDate birthDay;
}
