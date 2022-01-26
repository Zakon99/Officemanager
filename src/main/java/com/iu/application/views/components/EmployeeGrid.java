package com.iu.application.views.components;

import com.iu.application.entity.Artikel;
import com.iu.application.views.HomeView;
import com.vaadin.flow.component.grid.Grid;

import java.util.Set;

/**
 * Klasse für die EmployeeGrid
 * @author Mirsad Dzananovic
 */
public class EmployeeGrid {
    private HomeView homeView;
    private Grid<Artikel> grid = new Grid<>(Artikel.class);
    private Set<Artikel> selectedArtikel;

    public EmployeeGrid(HomeView homeView) {
        this.homeView = homeView;
        configureGrid();
    }

    /**
     * Konfiguriert das EmployeeGrid
     */
    private void configureGrid() {
        grid.addClassNames("artikel-grid");
        grid.setSizeFull();
        grid.setVisible(true);
        grid.setColumns("name", "anzahl", "preis", "kaufdatum","mitarbeiterName");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        configureComponents();
    }

    /**
     * Konfiguriert das verhalten der Components
     */
    private void configureComponents(){
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
