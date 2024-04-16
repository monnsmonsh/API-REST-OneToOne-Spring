package com.management.Management.service;

import com.management.Management.models.Employee;
import com.management.Management.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    //Mostrar
    public List<Employee> getAllEmployees(){
        return iEmployeeRepository.findAll();
    }

    //crear
    public Employee createEmployee(Employee employee){
        return iEmployeeRepository.save(employee);
    }

    //edit
    public Employee updateEmployee(Employee employee){
        return iEmployeeRepository.save(employee);
    }

    //eliminar
    public void deleteEmployeeById(Integer id){
        iEmployeeRepository.deleteById(id);
    }

}
