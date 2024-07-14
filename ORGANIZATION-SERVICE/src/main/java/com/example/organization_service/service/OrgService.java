package com.example.organization_service.service;

import com.example.organization_service.dto.OrgDto;
import com.example.organization_service.model.Organization;
import com.example.organization_service.repository.OrgRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    @Autowired
    private OrgRepository orgRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrgDto saveOrg(OrgDto orgDto){
        Organization organization=new Organization();
        if(orgDto !=null){
            modelMapper.map(orgDto,organization);
            orgRepository.save(organization);
            modelMapper.map(organization,orgDto);
        }
        return orgDto;
    }

    public OrgDto getOrg(String orgCode){
        OrgDto orgDto=new OrgDto();
        Organization organizationCode;
        if(! orgCode.isBlank() || ! orgCode.isEmpty()){
            organizationCode = orgRepository.findByOrganizationCode(orgCode);
            modelMapper.map(organizationCode,orgDto);
        }
       return orgDto;
    }
}
