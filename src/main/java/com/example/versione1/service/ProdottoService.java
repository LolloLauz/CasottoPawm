package com.example.versione1.service;

import com.example.versione1.model.Prodotto;
import com.example.versione1.repository.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepo prodottoRepo;


    public void addNewProdotto(Prodotto prodotto){
        prodottoRepo.save(prodotto);
    }

    public List<Prodotto> getAllProdotti(){
        return prodottoRepo.findAll();
    }
}
