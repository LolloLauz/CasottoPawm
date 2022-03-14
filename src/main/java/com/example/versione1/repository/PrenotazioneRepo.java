package com.example.versione1.repository;

import com.example.versione1.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrenotazioneRepo extends JpaRepository<Prenotazione,Long> {
}
