package com.example.versione1.service;

import com.example.versione1.model.*;
import com.example.versione1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdinazioniService {

    @Autowired
    private OrdinazioneRepo ordinazioneRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private OmbrelloneRepo ombrelloneRepo;
    @Autowired
    private ProdottoRepo prodottoRepo;
    @Autowired
    private DettagliOrdinazioneRepo dettagliOrdinazioneRepo;


    public void addNewOrdinazione(Ordinazione ordinazione,long idOmbrellone,long idProdotto,int quantita){
        Cliente cliente=clienteRepo.findAll().get(0);
        Ombrellone ombrellone=ombrelloneRepo.getById(idOmbrellone);
        Prodotto prodotto=prodottoRepo.getById(idProdotto);
        DettagliOrdinazione dettagliOrdinazione=new DettagliOrdinazione(quantita);
        ordinazione.setQrCode(ombrellone.getQrCode());
        cliente.addOrdinazione(ordinazione);
        prodotto.addDettagliOrdini(dettagliOrdinazione);
        dettagliOrdinazioneRepo.save(dettagliOrdinazione);
        ordinazioneRepo.save(ordinazione);
    }

    public List<Ordinazione> getAllOrdinazioni(){
        return ordinazioneRepo.findAll();
    }
}
