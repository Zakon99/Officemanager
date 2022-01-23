package com.iu.application.logic;

import com.iu.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class LoginLogic {
    private final UserService userService;

    @Autowired
    public LoginLogic() {
        userService = new UserService();
    }

    // Diese Methode überprüft, ob sich der eingebene Benutzername in der DB befindet
    public boolean userExcists(String username) {
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

    // Diese Methode überprüft, ob das eingegebene Passwort korrekt ist
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
