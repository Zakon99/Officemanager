package com.iu.application.entity;

import java.util.List;

public class ArtikelListe {
    List<Artikel> artikelListe;

    public ArtikelListe(List<Artikel> artikelListe) {
        this.artikelListe = artikelListe;
    }

    //Getter & Setter
    public List<Artikel> getArtikelListe() {
        return artikelListe;
    }
}
