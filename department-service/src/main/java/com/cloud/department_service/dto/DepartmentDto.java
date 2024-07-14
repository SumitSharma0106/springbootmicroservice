package com.cloud.department_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "DepartmentDTO Model Definition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @Schema(description = "Department ID")
    private long id;
    @Schema(description = "Department Name")
    private String departmentName;
    @Schema(description = "Department Description")
    private String departmentDescription;
    @Schema(description = "Department Code")
    private String departmentCode;
}
