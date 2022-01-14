package com.iu.application.entity;


import java.time.LocalDate;

public class Artikel {
    private Long userID;
    private String name;
    private Gruppe gruppe;
    private int anzahl;
    private double preis;
    private LocalDate kaufDatum;

    public Artikel(Long userID, String name, Gruppe gruppe, int anzahl, double preis, LocalDate kaufDatum) {
        this.userID = userID;
        this.name = name;
        this.gruppe = gruppe;
        this.anzahl = anzahl;
        this.preis = preis;
        this.kaufDatum = kaufDatum;
    }

    public void setKaufDatum(LocalDate kaufDatum) {
        this.kaufDatum = kaufDatum;
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

    public LocalDate getKaufDatum() {
        return kaufDatum;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Gruppe getGruppe() {
        return gruppe;
    }

    public void setGruppe(Gruppe gruppe) {
        this.gruppe = gruppe;
    }
}