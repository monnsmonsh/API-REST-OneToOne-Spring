package com.management.Management.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor//contructor que no tiene argumentos
@AllArgsConstructor//contructor que va ha tiene argumentos
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;

    private String name;
    private String lastName;
    private String birthDate;
    private String phone;

    @OneToOne
    private Management management;
}
