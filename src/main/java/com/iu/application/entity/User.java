package com.iu.application.entity;

/**
 * Klasse für den User
 * @author Dominik Laval
 */
public class User {
    private int id;
    private String username;
    private String pw;

    public User(int id, String username, String pw) {
        this.id = id;
        this.username = username;
        this.pw = pw;
    }
}
