package com.cloud.employee_service.service;

import com.cloud.employee_service.dto.ApiResponseDto;
import com.cloud.employee_service.dto.DepartmentDto;
import com.cloud.employee_service.dto.EmployeeDto;
import com.cloud.employee_service.model.Employee;
import com.cloud.employee_service.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private ApiClient apiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        if(employeeDto !=null){
            modelMapper.map(employeeDto,employee);
            Employee save = employeeRepository.save(employee);
            modelMapper.map(save,employeeDto);
        }
        return employeeDto;
    }

    public ApiResponseDto getEmployeeByID(Long id){
        EmployeeDto employeeDto=new EmployeeDto();
        Optional<Employee> byId = employeeRepository.findById(id);
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + byId.get().getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto body = departmentDtoResponseEntity.getBody();
//        DepartmentDto departmentResponse = webClient.get()
//                .uri("http://localhost:8080/api/department/" + byId.get().getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class).block();
        DepartmentDto department = apiClient.getDepartment(byId.get().getDepartmentCode());

        byId.ifPresent(employee -> modelMapper.map(employee, employeeDto));

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(department);

        return apiResponseDto;

    }
}
