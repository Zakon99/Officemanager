package com.iu.application.services;

import com.iu.application.entity.Artikel;
import com.iu.application.entity.ArtikelListe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Klasse zum Verwalten der Datenbankanfragen im bezug auf ein oder mehrere Artikel
 * @author Hari Rait
 */
@Service
public class ArtikelService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Stmt
    private final String getUserArtikelQuerry="SELECT * FROM article WHERE userId = (?)";

    private final String deleteArtikelQuerry= "DELETE FROM article WHERE userId = (?) AND name = (?)";


    /**
     * Holt die Artikel des users von der Datenbank
     * @param userId
     * @return ArtikelListe
     */
    public ArtikelListe getUserArtiekl(Long userId){
        return new ArtikelListe(jdbcTemplate.query(getUserArtikelQuerry,new Object[]{userId},new BeanPropertyRowMapper<>(Artikel.class)));
    }

    /**
     * Löscht ein Artikel von der Datenbank
     * @param artikelListe
     */
    public void deleteArtikel(Set<Artikel> artikelListe) {
        for(Artikel artikel:artikelListe){
            jdbcTemplate.update(deleteArtikelQuerry,new Object[]{artikel.getUserID(),artikel.getName()});
        }
    }
}
