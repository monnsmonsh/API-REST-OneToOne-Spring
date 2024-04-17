package com.management.Management.controller;


import com.management.Management.models.Management;
import com.management.Management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/management")
@CrossOrigin(origins = "*")//para poder utilizar el frontend
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    //GET
    @GetMapping
    public List<Management> listAll(){

        return managementService.getAllManagements();
    }

    //POST
    @PostMapping
    public Management create(@RequestBody Management management){
        return managementService.createManagement(management);
    }

    //PUT
    @PostMapping("edit/{id}")
    public Management update(@RequestBody Management management, @PathVariable Integer id){
        management.setIdManagement(id);
        return managementService.updateManagement(management);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){
        managementService.deleteManagementById(id);
    }
}
