package com.iu.application.views.components;

import com.iu.application.entity.Artikel;
import com.iu.application.views.HomeView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

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
        grid.setColumns("name", "anzahl", "preis", "kaufdatum");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

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
