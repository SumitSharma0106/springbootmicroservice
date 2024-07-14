package com.cloud.employee_service.service;

import com.cloud.employee_service.dto.ApiResponseDto;
import com.cloud.employee_service.dto.DepartmentDto;
import com.cloud.employee_service.dto.EmployeeDto;
import com.cloud.employee_service.dto.OrgDto;
import com.cloud.employee_service.model.Employee;
import com.cloud.employee_service.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    @Autowired
    private OrgApiClient orgApiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        if(employeeDto !=null){
            modelMapper.map(employeeDto,employee);
            Employee save = employeeRepository.save(employee);
            modelMapper.map(save,employeeDto);
        }
        return employeeDto;
    }

    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public ApiResponseDto getEmployeeByID(Long id){
        EmployeeDto employeeDto=new EmployeeDto();
        Optional<Employee> byId = employeeRepository.findById(id);
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + byId.get().getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto body = departmentDtoResponseEntity.getBody();
//        DepartmentDto departmentResponse = webClient.get()
//                .uri("http://localhost:8080/api/department/" + byId.get().getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class).block();
        DepartmentDto departmentResponse = apiClient.getDepartment(byId.get().getDepartmentCode());

        OrgDto orgResponse = orgApiClient.getOrg(byId.get().getOrganizationCode());

        byId.ifPresent(employee -> modelMapper.map(employee, employeeDto));

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentResponse);
        apiResponseDto.setOrgDto(orgResponse);


        return apiResponseDto;

    }

    public ApiResponseDto getDefaultDepartment(Long id,Exception exception) {

        EmployeeDto employeeDto=new EmployeeDto();
        Optional<Employee> byId = employeeRepository.findById(id);
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + byId.get().getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto body = departmentDtoResponseEntity.getBody();
//        DepartmentDto departmentResponse = webClient.get()
//                .uri("http://localhost:8080/api/department/" + byId.get().getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class).block();
//        DepartmentDto department = apiClient.getDepartment(byId.get().getDepartmentCode());
//
        byId.ifPresent(employee -> modelMapper.map(employee, employeeDto));
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }



}
