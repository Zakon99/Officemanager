package com.iu.application.views;

import com.iu.application.logic.LoginLogic;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Dominik Lavall
 */
@PageTitle("login")
@Route(value = "officmanager.com")
@RouteAlias(value = "")
public class LoginView extends VerticalLayout {
    private final LoginLogic loginLogic;

    //Components
    private TextField usernameTextfield = new TextField();
    private PasswordField passwordTextfield = new PasswordField();
    private Button loginButton = new Button("Login");
    private Label welcomeLabel = new Label("Willkommen zu deinem Officemanager.");
    private Label statusLabel = new Label("");
    private Label headerTitel = new Label("Officemanager");

    @Autowired
    public LoginView(LoginLogic loginLogic) {
        this.loginLogic = loginLogic;
        //this.getStyle().set("border","6px dotted DarkOrange");
        this.getStyle().set("background-color", "#34495E");
        this.setSizeFull();
        this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.START);
        this.add(addHeader(), addWelcomePanel(), addLoginPanel(), addFooter());
        this.setPadding(false);
        this.setSpacing(false);

        loginButton.addClickListener(event -> {
            String username = usernameTextfield.getValue();
            String password = passwordTextfield.getValue();
            if (loginLogic.userExcists(username) && loginLogic.checkPassword(password)) {
                UI.getCurrent().navigate("HomeView");
            } else {
                statusLabel.setText("Benutzername oder Passwort sind falsch.");
            }
        });
    }

    /**
     * Diese Methode erstellt den Header-Container
     * @return Layout für den Header
     */
    private HorizontalLayout addHeader() {
        HorizontalLayout headerLayout = new HorizontalLayout(headerTitel);
        //headerLayout.getStyle().set("border", "6px dotted Yellow");
        headerLayout.getStyle().set("background-color", "#17202A");
        headerLayout.setJustifyContentMode(JustifyContentMode.START);
        headerLayout.setHeight("10%");
        headerLayout.setWidthFull();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerTitel.getStyle().set("color", "White");
        headerTitel.getStyle().set("font", "Arial");
        headerTitel.getStyle().set("font-size", "32px");
        headerTitel.getStyle().set("margin-left", "280px");
        return headerLayout;
    }

    /**
     * Diese Methode erstellt den Welcome-Container
     * @return Layout für das Welcomepanel
     */
    private HorizontalLayout addWelcomePanel() {
        HorizontalLayout welcomeLayout = new HorizontalLayout(welcomeLabel);
        welcomeLabel.getStyle().set("font", "Arial");
        welcomeLabel.getStyle().set("font-size", "48px");
        welcomeLabel.getStyle().set("color", "White");
        welcomeLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        welcomeLayout.setHeight("30%");
        welcomeLayout.setWidth("70%");
        welcomeLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        welcomeLayout.getStyle().set("border", "2px solid Grey");
        welcomeLayout.getStyle().set("margin", "20px");
        return welcomeLayout;
    }

    /**
     * Diese Methode erstellt den Login-Container
     * @return Layout für das Loginpanel
     */
    private VerticalLayout addLoginPanel() {
        VerticalLayout loginLayout = new VerticalLayout(statusLabel, usernameTextfield, passwordTextfield, loginButton);
        loginLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        loginLayout.setHeight("40%");
        loginLayout.setWidth("70%");
        usernameTextfield.setLabel("Benutzername");
        usernameTextfield.getStyle().set("color", "#17202A");
        usernameTextfield.setWidth("30%");
        passwordTextfield.setLabel("Passwort");
        passwordTextfield.getStyle().set("color", "#17202A");
        passwordTextfield.setWidth("30%");
        passwordTextfield.setClearButtonVisible(true);
        passwordTextfield.setRevealButtonVisible(false);
        loginButton.getStyle().set("background-color", "#17202A");
        loginButton.getStyle().set("color", "White");
        loginButton.setWidth("30%");
        statusLabel.getStyle().set("color", "RED");
        loginLayout.getStyle().set("border", "2px solid Grey");
        loginLayout.getStyle().set("margin-bottom", "20px");
        return loginLayout;
    }

    /**
     * Diese Methode erstellt den Footer-Container
     * @return Layout für den Footer
     */
    private HorizontalLayout addFooter() {
        HorizontalLayout footerLayout = new HorizontalLayout();
        //footerLayout.getStyle().set("border", "6px dotted Violet");
        footerLayout.getStyle().set("background-color", "#17202A");
        footerLayout.setJustifyContentMode(JustifyContentMode.END);
        footerLayout.setHeight("20%");
        footerLayout.setWidthFull();
        footerLayout.setAlignItems(Alignment.CENTER);
        return footerLayout;
    }

}
