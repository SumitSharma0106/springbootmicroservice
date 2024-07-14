package com.example.organization_service.repository;

import com.example.organization_service.dto.OrgDto;
import com.example.organization_service.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepository extends JpaRepository<Organization,Long> {

    Organization findByOrganizationCode(String orgCode);

}
