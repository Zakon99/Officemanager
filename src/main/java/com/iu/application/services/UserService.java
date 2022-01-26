package com.iu.application.services;

import com.iu.application.entity.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Klasse für Datenbankabfragen im bezug auf ein User
 * @author Dominik Lavall
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Stmt
    private static final String selectUsername = "SELECT username FROM officemanager.user WHERE username = (?)";
    private static final String selectPassword = "SELECT pw FROM officemanager.user WHERE username = (?)";

    public UserService() {
        DBConfig dbConfig = new DBConfig();
        jdbcTemplate = new JdbcTemplate(dbConfig.dataSource());
    }

    /**
     *Datenbankabfrage für den Username
     * @param username
     * @return Username als String
     * @throws SQLException
     */
    public String getUsername(String username) throws SQLException {
        return jdbcTemplate.queryForObject(selectUsername, new Object[]{username}, String.class);
    }

    /**
     *Datenbankabfrage für das Userpassword
     * @param username
     * @return Passwort als String
     * @throws SQLException
     */
    public String getPassword(String username) throws SQLException {
        return jdbcTemplate.queryForObject(selectPassword, new Object[]{username},String.class);
    }
}
