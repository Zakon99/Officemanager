package com.iu.application.services;

import com.iu.application.entity.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
public class DatabaseService {

    private static final String selectUsername = "SELECT username FROM officemanager.user WHERE username = (?)";
    private static final String selectPassword = "SELECT pw FROM officemanager.user WHERE username = (?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DatabaseService() {
        DBConfig dbConfig = new DBConfig();
        jdbcTemplate = new JdbcTemplate(dbConfig.dataSource());
    }

    public String getUsername(String username) throws SQLException {
        return jdbcTemplate.query(selectUsername, new Object[]{username}, new BeanPropertyRowMapper<>(User.class)).toString();
    }

    public String getPassword(String username) throws SQLException {
        return jdbcTemplate.query(selectPassword, new Object[]{username}, new BeanPropertyRowMapper<>(User.class)).toString();
    }


}
