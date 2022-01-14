package com.iu.application.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;

public class Artikel {

    @NotEmpty
    private long userId;

    @NotEmpty
    private String name;

    @NotEmpty
    private Gruppe gruppe;

    @NotEmpty
    private int anzahl;

    @NotEmpty
    private double preis;

    @DateTimeFormat
    private String kaufdatum;

    public Artikel(long userId, String name, Gruppe gruppe, int anzahl, double preis, String kaufdatum) {
        this.userId = userId;
        this.name = name;
        this.gruppe = gruppe;
        this.anzahl = anzahl;
        this.preis = preis;
        this.kaufdatum = kaufdatum;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gruppe getGruppe() {
        return gruppe;
    }

    public void setGruppe(Gruppe gruppe) {
        this.gruppe = gruppe;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
    

    public String getKaufdatum() {
        return kaufdatum;
    }

    public void setKaufdatum(String kaufdatum) {
        this.kaufdatum = kaufdatum;
    }
}
