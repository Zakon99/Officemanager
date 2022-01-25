package com.iu.application.logic;

import com.iu.application.entity.Artikel;
import com.iu.application.entity.ArtikelListe;
import com.iu.application.services.ArtikelService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
public class ArtikelLogic {
    private final ArtikelService artikelService;

    @Autowired
    public ArtikelLogic(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    public ArtikelListe getUserArtikel(long userId){
        return artikelService.getUserArtiekl(userId);
    }

    public void deleteArtikel(Set<Artikel> artikelListe){
        artikelService.deleteArtikel(artikelListe);
    }
}
