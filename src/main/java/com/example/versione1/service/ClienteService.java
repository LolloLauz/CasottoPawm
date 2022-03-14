package com.example.versione1.service;

import com.example.versione1.model.Cliente;
import com.example.versione1.model.Prenotazione;
import com.example.versione1.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepo clienteRepo;

    public void addNewCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }

    public List<Cliente> getAllClienti(){
        return clienteRepo.findAll();
    }

    public Cliente getClienteById(Long id){
        return clienteRepo.findById(id).orElseThrow();
    }

    public List<Prenotazione> getPrenotazioneOfOneClient(Long idCliente){
        return clienteRepo.getPrenotazioneFromOneClient(idCliente);
    }
}
