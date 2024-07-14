package com.cloud.employee_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgDto {

    private Long id;
    private String organizationDescription;
    private String organizationName;
    private String organizationCode;
    private LocalDateTime createdDate;
}
