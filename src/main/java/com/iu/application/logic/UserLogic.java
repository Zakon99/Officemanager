package com.iu.application.logic;

import com.iu.application.entity.User;
import com.iu.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Klasse zum verwalten der Logiken für den User
 * @author Dominik Lavall
 */
@RestController
public class UserLogic {
    private final UserService userService;

    @Autowired
    public UserLogic(UserService userService) {
        this.userService = userService;
    }

    /**
     * Diese Methode überprüft, ob sich der eingebene Benutzername in der DB befindet
     * @param username
     * @return true, wenn Benutzer vorhanden ist
     */
    public boolean checkIfUserExcists(String username) {
        try {
            String databaseUsername = userService.getUsername(username);
            if (username.equals(databaseUsername)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *Diese Methode überprüft, ob das eingegebene Passwort korrekt ist
     * @param username
     * @return true, wenn das Passwort korrekt ist
     */
    public boolean checkPassword(String username) {
        try {
            String databasePassword = userService.getPassword(username);
            if (username.equals(databasePassword)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
