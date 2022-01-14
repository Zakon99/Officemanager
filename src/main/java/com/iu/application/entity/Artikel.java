package com.iu.application.entity;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Artikel {
    private Long userID;
    private String name;
    private int anzahl;
    private double preis;
    private LocalDate kaufDatum;

    public Artikel(Long userID, String name, int anzahl, double preis, LocalDate kaufDatum) {
        this.userID = userID;
        this.name = name;
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
}