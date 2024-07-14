package com.example.organization_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String organizationDescription;
    @Column(nullable = false)
    private String organizationName;
    @Column(nullable = false,unique = true)
    private String organizationCode;
    @CreationTimestamp
    private LocalDateTime createdDate;
}
