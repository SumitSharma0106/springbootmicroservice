package com.cloud.employee_service.Controller;

import com.cloud.employee_service.dto.ApiResponseDto;
import com.cloud.employee_service.dto.EmployeeDto;
import com.cloud.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeByID(id),HttpStatus.OK);
    }
}
