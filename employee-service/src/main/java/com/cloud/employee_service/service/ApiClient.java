package com.cloud.employee_service.service;

import com.cloud.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("/api/department/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);
}
