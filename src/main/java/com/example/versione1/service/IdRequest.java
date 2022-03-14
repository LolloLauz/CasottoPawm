package com.example.versione1.service;

public class IdRequest {
    private Long idOmbrellone;
    private Long idPrenotazione;

    public IdRequest() {
    }

    public Long getIdPrenotazione() {
        return idPrenotazione;
    }

    public Long getIdOmbrellone() {
        return idOmbrellone;
    }

    public void setIdOmbrellone(Long idOmbrellone) {
        this.idOmbrellone = idOmbrellone;
    }

    @Override
    public String toString() {
        return "IdRequest{" +
                "idOmbrellone=" + idOmbrellone +
                ", idPrenotazione=" + idPrenotazione +
                '}';
    }
}
