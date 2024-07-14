package com.cloud.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
    private String organizationCode;
}
