package com.iu.application.views.list;

import com.iu.application.entity.Artikel;
import com.iu.application.logic.AbschreibungLogic;
import com.iu.application.views.HomeView;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArtikelForm{
    private HomeView homeView;

    private AbschreibungLogic abschreibungLogic;

    private FormLayout artieklForm = new FormLayout();

    @Autowired
    private ArtikelGrid artikelGrid;

    //Fields
    private NumberField userId = new NumberField("User Id");
    private TextField name = new TextField("Name");
    private ComboBox<String> gruppen = new ComboBox<>("Gruppen");
    private TextField anzahl = new TextField("Anzahl");
    private NumberField preis = new NumberField("Preis");
    private DatePicker kaufdatum = new DatePicker("Kaufdatum");

    //Buttons
    private Button save = new Button("speichern");
    private Button delete = new Button("löschen");
    private Button close = new Button("schließen");
    private Button createAbschreibung = new Button("Abschreibung erstellen");

    public ArtikelForm(HomeView homeView){
        this.homeView = homeView;
        artieklForm.setVisible(true);
        configureButtonActions();
        artieklForm.add(userId, name, anzahl, preis, kaufdatum, createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        createAbschreibung.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close,createAbschreibung);
    }

    /**
     * Setzt die Aktionen für die Buttons;
     */
    private void configureButtonActions(){
        createAbschreibung.addClickListener(buttonClickEvent -> {
            abschreibungLogic = new AbschreibungLogic();
            for(Artikel artikel : artikelGrid.getSelectedArtikel()){
                abschreibungLogic.createAbschreibung(artikel);
            }
        });
    }

    //Getter & Setter
    public FormLayout getArtieklForm() {
        return artieklForm;
    }
}
