package com.example.versione1.controller;

import com.example.versione1.model.Ombrellone;
import com.example.versione1.service.OmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ombrellone")
public class OmbrelloneController {

    @Autowired
    private OmbrelloneService ombrelloneService;

    @PostMapping("/addNewOmbrellone")
    public void addNewOmbrellone(@RequestBody Ombrellone ombrellone){
        ombrelloneService.addNewOmbrellone(ombrellone);
    }

    @GetMapping("/getAllOmbrelloni")
    public List<Ombrellone> getAllOmbrelloni(){
        return ombrelloneService.getAllOmbrelloni();
    }
}
