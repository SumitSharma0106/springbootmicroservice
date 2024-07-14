package com.example.organization_service.controller;


import com.example.organization_service.dto.OrgDto;
import com.example.organization_service.service.OrgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Organization API Rest Controller",
        description = "Organization API Rest Controller to Save & Get Org Object from DB")
@RestController
@RequestMapping("/api/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @Operation(summary = "Save Organization Api",description = "Save Organization Api Object in DB")
    @ApiResponse(responseCode = "201",description = "HTTP Status 201")
    @PostMapping
    public OrgDto saveOrg(@RequestBody OrgDto orgDto){
        return orgService.saveOrg(orgDto);
    }

    @Operation(summary = "Get Organization Api",description = "Get Organization Api Object from DB")
    @ApiResponse(responseCode = "201",description = "HTTP Status 201")
    @GetMapping("/{orgCode}")
    public OrgDto getOrg(@PathVariable String orgCode){
        return orgService.getOrg(orgCode);
    }
}
