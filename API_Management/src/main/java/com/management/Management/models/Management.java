package com.management.Management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idManagement;

    private String name;
    private String phone;
}
