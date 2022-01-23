package com.iu.application.logic;

import com.iu.application.entity.ArtikelListe;
import com.iu.application.services.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

    public void deleteArtikel(ArtikelListe artikelListe){
        artikelService.deleteArtikel(artikelListe);
    }
}
