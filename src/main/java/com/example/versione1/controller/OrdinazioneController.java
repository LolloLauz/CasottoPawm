package com.example.versione1.controller;

import com.example.versione1.model.Ordinazione;
import com.example.versione1.repository.OrdinazioneRepo;
import com.example.versione1.service.OrdinazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordinazione")
public class OrdinazioneController {

    @Autowired
    private OrdinazioniService ordinazioniService;

    @PostMapping("/addNewOrdinazione/{idOmbrellone}/{idProdotto}/{quantita}")
    public void addNewOrdinazione(@RequestBody Ordinazione ordinazione,
                             @PathVariable long idOmbrellone,
                             @PathVariable long idProdotto,
                             @PathVariable int quantita){
        ordinazioniService.addNewOrdinazione(ordinazione,idOmbrellone,idProdotto,quantita);

    }

    @GetMapping("/getAllOrdinazioni")
    public List<Ordinazione> getAllOrdinazione(){
        return ordinazioniService.getAllOrdinazioni();
    }
}
