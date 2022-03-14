package com.example.versione1.repository;

import com.example.versione1.model.DettagliOrdinazione;
import com.example.versione1.model.Ordinazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdinazioneRepo extends JpaRepository<Ordinazione,Long> {
}
