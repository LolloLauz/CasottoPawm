package com.example.versione1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int quantitaMagazzino;
    private double prezzo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prodotto",referencedColumnName = "id")
    private Set<DettagliOrdinazione> dettagliOrdinazioni=new HashSet<>();

    public Prodotto() {
    }

    public Prodotto(String nome, int quantitaMagazzino, double prezzo) {
        this.nome = nome;
        this.quantitaMagazzino = quantitaMagazzino;
        this.prezzo = prezzo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantitaMagazzino() {
        return quantitaMagazzino;
    }

    public void setQuantitaMagazzino(int quantitaMagazzino) {
        this.quantitaMagazzino = quantitaMagazzino;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Set<DettagliOrdinazione> getDettagliOrdinazioni() {
        return dettagliOrdinazioni;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantitaMagazzino=" + quantitaMagazzino +
                ", prezzo=" + prezzo +
                '}';
    }

    public void addDettagliOrdini(DettagliOrdinazione dettagliOrdinazione) {
        dettagliOrdinazioni.add(dettagliOrdinazione);
    }
}
