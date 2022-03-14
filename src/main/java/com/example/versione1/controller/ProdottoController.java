package com.example.versione1.controller;

import com.example.versione1.model.Prodotto;
import com.example.versione1.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @PostMapping("addNewProdotto")
    public void addNewProdotto(@RequestBody Prodotto prodotto){
        prodottoService.addNewProdotto(prodotto);
    }

    @GetMapping("/getAllProdotti")
    public List<Prodotto> getAllProdotti(){
        return prodottoService.getAllProdotti();
    }
}
