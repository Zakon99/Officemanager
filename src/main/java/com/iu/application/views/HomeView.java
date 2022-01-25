package com.iu.application.views;

import com.iu.application.entity.User;
import com.iu.application.logic.LoginLogic;
import com.iu.application.views.list.ArtikelForm;
import com.iu.application.views.list.ArtikelGrid;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

@PageTitle("home")
@Route(value = "home",layout = MainLayout.class)
public class HomeView extends VerticalLayout implements HasUrlParameter<String> {
    private User user;

    private final LoginLogic loginLogic;

    private ArtikelGrid artikelGrid;
    private ArtikelForm artikelForm;

    @Autowired
    public HomeView(LoginLogic loginLogic) {
        this.loginLogic = loginLogic;
        artikelGrid = new ArtikelGrid(this);
        artikelForm = new ArtikelForm(this);

        HorizontalLayout content = new HorizontalLayout(artikelGrid.getGrid(), artikelForm.getArtieklForm());
        content.setFlexGrow(2, artikelGrid.getGrid());
        content.setFlexGrow(1, artikelForm.getArtieklForm());
        content.addClassNames("content");
        content.setSizeFull();

        add(content);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent,@OptionalParameter String parameter) {
        if(parameter == null || parameter.isEmpty()){
            //Pass User to Startpage
            UI.getCurrent().navigate(LoginView.class);
            UI.getCurrent().getPage().reload();
        }else{
            //Get User Informations and User Playlist
            try {
                user = loginLogic.getUser(Long.valueOf(parameter));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Set Items on grid
        }

    }
}
