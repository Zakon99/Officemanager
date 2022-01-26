package com.iu.application.views.components;

import com.iu.application.entity.Artikel;
import com.iu.application.views.HomeView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import java.util.Set;

/**
 * Klasse für ArtikelGrid
 * @author Hari Rait
 */
public class ArtikelGrid {
    private HomeView homeView;
    private Grid<Artikel> grid = new Grid<>(Artikel.class);
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

    //Getter & Setter
    public Set<Artikel> getSelectedArtikel() {
        return selectedArtikel;
    }

    public Grid<Artikel> getGrid() {
        return grid;
    }

}
