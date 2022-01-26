package com.iu.application.entity;

import java.time.LocalDate;

/**
 * Klasse für ein Artikel
 * @author Mirsad Dzananovic
 */
public class Artikel {
    private Long userID;
    private String name;
    private int anzahl;
    private double preis;
    private LocalDate kaufdatum;
    private String mitarbeiterName;

    public Artikel(Long userID, String name, int anzahl, double preis, LocalDate kaufdatum) {
        this.userID = userID;
        this.name = name;
        this.anzahl = anzahl;
        this.preis = preis;
        this.kaufdatum = kaufdatum;
    }

    public Artikel() {
    }

    //Getter&Setter
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getMitarbeiterName() {
        return mitarbeiterName;
    }

    public void setMitarbeiterName(String mitarbeiterName) {
        this.mitarbeiterName = mitarbeiterName;
    }

    public LocalDate getKaufdatum() {
        return kaufdatum;
    }

    public void setKaufdatum(LocalDate kaufdatum) {
        this.kaufdatum = kaufdatum;
    }
}