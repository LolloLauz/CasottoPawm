package com.example.versione1.repository;

import com.example.versione1.model.Cliente;
import com.example.versione1.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepo extends JpaRepository<Cliente,Long> {

    @Query("SELECT c.prenotazioni FROM Cliente c WHERE  c.id=?1")
    List<Prenotazione> getPrenotazioneFromOneClient(Long id);
}
