package com.example.versione1.model;

import javax.persistence.*;

@Entity
public class DettagliOrdinazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantita;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ordinazione",referencedColumnName = "id")
    private Ordinazione ordinazione;
    public DettagliOrdinazione() {
    }

    public DettagliOrdinazione(int quantita) {
        this.quantita = quantita;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Ordinazione getOrdinazione() {
        return ordinazione;
    }

    @Override
    public String toString() {
        return "DettagliOrdinazione{" +
                "id=" + id +
                ", quantita=" + quantita +
                '}';
    }
}
