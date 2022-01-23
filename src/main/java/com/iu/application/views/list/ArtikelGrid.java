package com.iu.application.views.list;

import com.iu.application.entity.Artikel;
import com.iu.application.views.HomeView;
import com.iu.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;
import java.util.Set;

public class ArtikelGrid {
    private HomeView homeView;
    private Grid<Artikel> grid = new Grid<>(Artikel.class);
    private TextField filterText = new TextField();
    private Set<Artikel> selectedArtikel;

    public ArtikelGrid(HomeView homeView) {
        this.homeView = homeView;
        configureGrid();
    }

    private void configureGrid() {
        grid.addClassNames("artikel-grid");
        grid.setSizeFull();
        grid.setVisible(true);
        grid.setColumns("userID", "name", "gruppe", "anzahl", "preis", "kaufDatum");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.addSelectionListener(event->{
            selectedArtikel = grid.getSelectedItems();
        });
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filtern");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        //Button addArtikelButton = new Button("Artikel hinzufügen...");

        HorizontalLayout toolbar = new HorizontalLayout(filterText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    //Getter & Setter
    public Set<Artikel> getSelectedArtikel() {
        return selectedArtikel;
    }

    public Grid<Artikel> getGrid() {
        return grid;
    }
}
