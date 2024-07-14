package com.example.organization_service.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(name = "Organization Object Model Definition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgDto {

    @Schema(description = "Org ID")
    private Long id;
    @Schema(description = "Org Description")
    private String organizationDescription;
    @Schema(description = "Org Name")
    private String organizationName;
    @Schema(description = "Org Code")
    private String organizationCode;
    @Schema(description = "Org Create TimeStamp")
    private LocalDateTime createdDate;
}
