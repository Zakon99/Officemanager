package com.iu.application.views;

import com.iu.application.views.list.ArtikelForm;
import com.iu.application.views.list.ArtikelGrid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("home")
@Route(value = "",layout = MainLayout.class)
public class HomeView extends VerticalLayout {
    private ArtikelGrid artikelGrid;
    private ArtikelForm artikelForm;

    public HomeView() {
        artikelGrid = new ArtikelGrid();

        add(artikelGrid.getGrid());
    }
}
