package com.iu.application.services;

import com.iu.application.entity.Artikel;
import com.iu.application.entity.ArtikelListe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ArtikelService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Stmt
    private final String getUserArtikelQuerry="SELECT * FROM article WHERE userId = (?)";

    private final String deleteArtikelQuerry= "DELETE FROM article WHERE userId = (?) AND name = (?)";


    /**
     * Get ArtikelListe from Database
     * @param userId
     * @return ArtikelListe
     */
    public ArtikelListe getUserArtiekl(Long userId){
        return new ArtikelListe(jdbcTemplate.query(getUserArtikelQuerry,new Object[]{userId},new BeanPropertyRowMapper<>(Artikel.class)));
    }

    public void deleteArtikel(ArtikelListe artikelListe) {
    }
}
