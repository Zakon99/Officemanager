package com.iu.application.views;

import com.iu.application.views.list.ArtikelForm;
import com.iu.application.views.list.ArtikelGrid;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

@PageTitle("home")
@Route(value = "",layout = MainLayout.class)
public class HomeView extends VerticalLayout implements HasUrlParameter<String> {

    private ArtikelGrid artikelGrid;
    private ArtikelForm artikelForm;

    public HomeView() {
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
            //UI.getCurrent().navigate(LoginView.class);
            UI.getCurrent().getPage().reload();
        }else{
            //Get User Informations and User Playlist
            /*
            user = userLogic.getUser(Long.valueOf(parameter));
            avatar.setName(user.getName());
            playlistGrid.getPlaylistGrid().setItems(playlistLogic.getUserPlaylist(user.getId()));
            userHeader.setText(user.getPlaylistname());
             */
        }

    }
}
