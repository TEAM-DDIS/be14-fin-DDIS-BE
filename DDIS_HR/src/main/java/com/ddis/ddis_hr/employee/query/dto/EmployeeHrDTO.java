package com.ddis.ddis_hr.employee.query.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Alias("EmployeeHrDTO")
public class EmployeeHrDTO {
    private Long employeeId;
    private String employeeName;
    private String employeePwd;
    private String employeePhotoName;
    private String employeePhotoUrl;
    private String employeeNation;
    private String employeeGender;
    private LocalDate employeeBirth;
    private String employeeResident;
    private String employeeContact;
    private String employeeEmail;
    private String employeeAddress;

    private LocalDate employmentDate;
    private LocalDate retirementDate;

    private String workType;
    private String bankName;
    private String bankDepositor;
    private String bankAccount;

    private String isDisorder;
    private String militaryType;
    private String isMarriage;
    private LocalDate marriageDate;
    private Integer familyCount;

    private Integer careerYearCount;
    private String previousCompany;

    private String finalAcademic;
    private String employeeSchool;
    private String employeeDept;
    private Integer graduationYear;

    private String isFourInsurances;
    private Long positionId;
    private Long rankId;
    private Long jobId;
    private Long headId;
    private Long departmentId;
    private Long teamId;

    private String positionName;
    private String rankName;
    private String jobName;
    private String headName;
    private String departmentName;
    private String teamName;

}
