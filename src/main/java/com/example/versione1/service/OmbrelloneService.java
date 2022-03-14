package com.example.versione1.service;

import com.example.versione1.model.Ombrellone;
import com.example.versione1.repository.OmbrelloneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OmbrelloneService {

     @Autowired
     private OmbrelloneRepo ombrelloneRepo;


     public void addNewOmbrellone(Ombrellone ombrellone){
         ombrelloneRepo.save(ombrellone);
     }

     public List<Ombrellone> getAllOmbrelloni(){
         return ombrelloneRepo.findAll();
     }
}
