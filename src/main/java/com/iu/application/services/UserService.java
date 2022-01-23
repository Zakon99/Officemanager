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
 * @author Dominik Lavall
 */

@Service
public class UserService {

    private static final String selectUsername = "SELECT username FROM officemanager.user WHERE username = (?)";
    private static final String selectPassword = "SELECT pw FROM officemanager.user WHERE username = (?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserService() {
        DBConfig dbConfig = new DBConfig();
        jdbcTemplate = new JdbcTemplate(dbConfig.dataSource());
    }

    /**
     *
     * @param username
     * @return Username als String
     * @throws SQLException
     */
    public String getUsername(String username) throws SQLException {
        return jdbcTemplate.queryForObject(selectUsername, new Object[]{username}, String.class);
    }

    /**
     *
     * @param username
     * @return Passwort als String
     * @throws SQLException
     */
    public String getPassword(String username) throws SQLException {
        return jdbcTemplate.queryForObject(selectPassword, new Object[]{username},String.class);
    }
}
