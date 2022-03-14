package com.example.versione1.controller;

import com.example.versione1.model.Ombrellone;
import com.example.versione1.model.Prenotazione;
import com.example.versione1.repository.PrenotazioneRepo;
import com.example.versione1.service.IdRequest;
import com.example.versione1.service.PrenotazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;


    @GetMapping("/getAllPrenotazioni")
    public List<Prenotazione> getAllPrenotazioni(){
        return prenotazioneService.getAllPrenotazioni();
    }


    @PostMapping("/addOmbrelloneToPrenotazione")
    public void addOmbrelloneToPrenotazione(@RequestBody IdRequest idRequest){
        System.out.println("Aggiungo gli ombrelloni");
        prenotazioneService.addOmbrelloneToPrenotazione(idRequest.getIdOmbrellone(),idRequest.getIdPrenotazione());
    }

    @GetMapping("/getOmbrelloniLiberi/{inizio}/{fine}")
    public List<Ombrellone> getOmbrelloniLiberi(@PathVariable String inizio,@PathVariable String fine){
        System.out.println("creo la prenotazione");
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInizio=LocalDate.parse(inizio,dtf);
        LocalDate dataFine=LocalDate.parse(fine,dtf);
        return prenotazioneService.getOmbrelloniLiberiInUnPeriodo(dataInizio,dataFine);
    }

    @GetMapping("/getOmbrelloniPrenotazione/{idPrenotazione}")
    public Set<Ombrellone> getOmbrelloniPrenotazione(@PathVariable Long idPrenotazione){
        return prenotazioneService.getOmbrelloniPrenotazione(idPrenotazione);
    }

    @PostMapping("/addNewPrenotazione")
    public long addPrenotazione(@RequestBody Prenotazione prenotazione){
        return prenotazioneService.addPrenotazione(prenotazione);
    }
}
