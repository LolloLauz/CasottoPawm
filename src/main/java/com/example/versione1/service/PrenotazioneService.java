package com.example.versione1.service;

import com.example.versione1.model.Cliente;
import com.example.versione1.model.Ombrellone;
import com.example.versione1.model.Prenotazione;
import com.example.versione1.repository.ClienteRepo;
import com.example.versione1.repository.OmbrelloneRepo;
import com.example.versione1.repository.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepo prenotazioneRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private OmbrelloneRepo ombrelloneRepo;


    public List<Prenotazione> getAllPrenotazioni(){
        return prenotazioneRepo.findAll();
    }

    public void addOmbrelloneToPrenotazione(Long idOmbrellone,Long idPrenotazione){
        Ombrellone ombrellone=ombrelloneRepo.getById(idOmbrellone);
        Prenotazione prenotazione=prenotazioneRepo.getById(idPrenotazione);
        prenotazione.addOmbrellone(ombrellone);
        prenotazioneRepo.save(prenotazione);
    }

    public long addPrenotazione(Prenotazione prenotazione){
        Cliente cliente=clienteRepo.findAll().get(0);
        cliente.addPrenotazione(prenotazione);
        return prenotazioneRepo.save(prenotazione).getId();
    }

    public Set<Ombrellone> getOmbrelloniPrenotazione(long idPrenotazione){
        return prenotazioneRepo.findById(idPrenotazione).orElseThrow().getOmbrelloni();
    }

    public List<Ombrellone> getOmbrelloniLiberiInUnPeriodo(LocalDate dataInizio,LocalDate dataFine){
        List<Ombrellone> ombrelloni=new ArrayList<>();
        ombrelloni.addAll(ombrelloneRepo.findAll());
        List<Prenotazione> prenotazioni=new ArrayList<>();
        prenotazioni.addAll(prenotazioneRepo.findAll());
        for(Prenotazione prenotazione:prenotazioni){
            if(checkDate(prenotazione,dataInizio,dataFine)){
                ombrelloni.removeAll(prenotazione.getOmbrelloni());
            }
        }

        return ombrelloni;
    }

    private boolean checkDate(Prenotazione prenotazione,LocalDate dataInizio, LocalDate dataFine){
        return (prenotazione.getDataInizio().isBefore(dataInizio) && prenotazione.getDataFine().isAfter(dataFine)) ||
                (prenotazione.getDataInizio().isAfter(dataInizio) && prenotazione.getDataFine().isBefore(dataFine)) ||
                (prenotazione.getDataInizio().isBefore(dataInizio) && prenotazione.getDataFine().isAfter(dataInizio)) ||
                (prenotazione.getDataInizio().isBefore(dataFine) && prenotazione.getDataFine().isAfter(dataFine)) ||
                (prenotazione.getDataInizio().isEqual(dataInizio) && prenotazione.getDataFine().isEqual(dataFine)) ||
                (prenotazione.getDataInizio().isEqual(dataInizio) && prenotazione.getDataFine().isBefore(dataFine))||
                (prenotazione.getDataInizio().isEqual(dataInizio) && prenotazione.getDataFine().isAfter(dataFine));
    }
}
