package com.cloud.department_service.controller;

import com.cloud.department_service.dto.DepartmentDto;
import com.cloud.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode){
        DepartmentDto departmentByCode = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentByCode,HttpStatus.OK);
    }
}
