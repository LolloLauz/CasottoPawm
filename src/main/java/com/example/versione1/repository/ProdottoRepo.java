package com.example.versione1.repository;

import com.example.versione1.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepo extends JpaRepository<Prodotto,Long> {
}
