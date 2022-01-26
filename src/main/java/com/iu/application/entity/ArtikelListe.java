package com.iu.application.entity;

import java.util.List;

/**
 * Klasse für die ArtikelListe
 * @author Mirsad Dzananovic
 */
public class ArtikelListe {
    private List<Artikel> artikelListe;

    public ArtikelListe(List<Artikel> artikelListe) {
        this.artikelListe = artikelListe;
    }

    //Getter & Setter
    public List<Artikel> getArtikelListe() {
        return artikelListe;
    }
}
