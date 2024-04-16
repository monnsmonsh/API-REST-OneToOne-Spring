package com.management.Management.service;

import com.management.Management.models.Management;
import com.management.Management.repository.IManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagementService {

    @Autowired
    private IManagementRepository iManagementRepository;

    //Mostrar
    public List<Management> getAllManagements(){
        return iManagementRepository.findAll();
    }

    //crear
    public Management createManagement(Management management){
        return iManagementRepository.save(management);
    }

    //edit
    public Management updateManagement(Management management){
        return iManagementRepository.save(management);
    }

    //eliminar
    public void deleteManagementById(Integer id){
        iManagementRepository.deleteById(id);
    }


}
