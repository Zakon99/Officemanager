package com.iu.application.logic;

import com.iu.application.entity.Artikel;
import com.iu.application.entity.ArtikelListe;
import com.iu.application.services.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

/**
 * Klasse zur verwaltung der Logiken für die Artikel
 * @author Hari Rait
 */
@RestController
public class ArtikelLogic {
    private final ArtikelService artikelService;

    @Autowired
    public ArtikelLogic(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    /**
     * Logik für den Anstoß um die Artikel vom User von der Datenbank zu bekommen
     * @param userId
     * @return ArtikelListe vom User
     */
    public ArtikelListe getUserArtikel(long userId){
        return artikelService.getUserArtiekl(userId);
    }

    /**
     * Logik für den Anstoß um ein Artikel vom User auf der Datenbank zu löschen
     * @param artikelListe
     */
    public void deleteArtikel(Set<Artikel> artikelListe){
        artikelService.deleteArtikel(artikelListe);
    }
}
