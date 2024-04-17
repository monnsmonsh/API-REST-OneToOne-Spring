package com.management.Management.controller;


import com.management.Management.models.Employee;
import com.management.Management.models.Management;
import com.management.Management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin(origins = "*")//para poder utilizar el frontend
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    //GET
    @GetMapping
    public List<Employee> listAll(){
        return employeeService.getAllEmployees();
    }

    //POST
    @PostMapping
    public Employee create(@RequestBody Employee employee){

        return employeeService.createEmployee(employee);
    }

    //PUT
    @PostMapping("edit/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable Integer id){
        employee.setIdEmployee(id);
        return employeeService.updateEmployee(employee);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
    }


}
