package com.example.versione1.controller;

import com.example.versione1.model.Cliente;
import com.example.versione1.model.Prenotazione;
import com.example.versione1.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @PostMapping("/addNewCliente")
    public void addNewCliente(@RequestBody Cliente cliente){
        clienteService.addNewCliente(cliente);
    }

    @GetMapping("/getAllClienti")
    public List<Cliente> getAllClienti(){
        return clienteService.getAllClienti();
    }

    @GetMapping("/getClienteById/{idCliente}")
    public Cliente getClienteById(@PathVariable Long idCliente){
        return clienteService.getClienteById(idCliente);
    }

    @GetMapping("/getPrenotazioniCliente/{idCliente}")
    public List<Prenotazione> getClienteOfOneClient(@PathVariable Long idCliente){
        System.out.println(clienteService.getPrenotazioneOfOneClient(idCliente));
        return clienteService.getPrenotazioneOfOneClient(idCliente);
    }


}
