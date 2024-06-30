package com.cloud.department_service.service;

import com.cloud.department_service.dto.DepartmentDto;
import com.cloud.department_service.model.Department;
import com.cloud.department_service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Value("${server.port}")
    private String port;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        Department department=new Department();
        if(departmentDto !=null){
            modelMapper.map(departmentDto,department);
            Department save = departmentRepository.save(department);
            modelMapper.map(save,departmentDto);
        }
        return departmentDto;
    }

    public DepartmentDto getDepartmentByCode(String departmentCode){
        log.info("Response from {}",port);
        DepartmentDto departmentDto=new DepartmentDto();
        if(! departmentCode.isEmpty() || ! departmentCode.isBlank()){
            Department byDepartmentCode = departmentRepository.findByDepartmentCode(departmentCode);
            modelMapper.map(byDepartmentCode,departmentDto);
        }
        return departmentDto;
    }
}
