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

    private final String getUserArtikel="SELECT * FROM article WHERE userID = (?)";


    /**
     * Get ArtikelListe from Database
     * @param userId
     * @return ArtikelListe
     */
    public ArtikelListe getUserArtiekl(Long userId){
        return new ArtikelListe(jdbcTemplate.query(getUserArtikel,new Object[]{userId},new BeanPropertyRowMapper<>(Artikel.class)));
    }
}
