package com.iu.application.data.views.list;

import com.iu.application.data.entity.Artikel;
import com.iu.application.data.views.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.swing.text.html.ListView;

import java.util.Collections;

import static io.swagger.v3.core.util.AnnotationsUtils.getContent;

@PageTitle("Artikelliste | Officemanager")
@Route(value = "officemanager.com/Artikelliste", layout = HomeView.class)
public class
ArtikelListe extends VerticalLayout {
    Grid<Artikel> grid = new Grid<>(Artikel.class);
    TextField filterText = new TextField();
    ArtikelForm form;

    public ArtikelListe() {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureForm();
        add(getToolbar(), grid, getContent());
    }

    private void configureForm() {
        form = new ArtikelForm(Collections.emptyList());
        form.setWidth("25em");
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassNames("artikel-grid");
        grid.setSizeFull();
        grid.setColumns("userId", "name", "gruppe", "anzahl", "preis", "kaufdatum");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
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


}
