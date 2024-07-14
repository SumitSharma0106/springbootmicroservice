package com.cloud.employee_service.service;

import com.cloud.employee_service.dto.OrgDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrgApiClient {

    @GetMapping("/api/org/{orgCode}")
    public OrgDto getOrg(@PathVariable String orgCode);
}
