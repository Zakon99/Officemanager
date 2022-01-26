package com.iu.application.views.components;

import com.iu.application.entity.Artikel;
import com.iu.application.logic.AbschreibungLogic;
import com.iu.application.logic.ArtikelLogic;
import com.iu.application.views.HomeView;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

/**
 * Klasse für die erstellung der ArtikelForm
 * @author Hari Rait, Mirsad Dzananovic
 */
public class ArtikelForm{
    private ArtikelLogic artikelLogic;
    private AbschreibungLogic abschreibungLogic;
    private HomeView homeView;
    //Components
    private FormLayout artieklForm = new FormLayout();
    //Fields
    private TextField artikel_name = new TextField("Artikel Name");
    private TextField anzahl = new TextField("Anzahl");
    private NumberField preis = new NumberField("Preis (Preis in Euro)");
    private DatePicker kaufdatum = new DatePicker("Kaufdatum");
    private TextField employeeName = new TextField("Mitarbeiter Name");
    //Buttons
    private Button add = new Button("Hinzufügen");
    private Button delete = new Button("Löschen");
    private Button transferToEmployee = new Button("Mitarbeiter überschreiben");
    private Button createAbschreibung = new Button("Abschreibung erstellen");

    public ArtikelForm(HomeView homeView,ArtikelLogic artikelLogic){
        this.homeView = homeView;
        this.artikelLogic = artikelLogic;

        configureFormStyle();
        configureButtonActions();
        artieklForm.add(artikel_name,anzahl, preis, kaufdatum,employeeName,createButtonsLayout());
    }

    /**
     * Konfiguriert die Style Parameter der Form
     */
    private void configureFormStyle(){
        artieklForm.setVisible(true);
    }

    /**
     * Erstellt das ButtonLayout
     * @return Layout für Buttons
     */
    private HorizontalLayout createButtonsLayout() {
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        transferToEmployee.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        createAbschreibung.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        add.addClickShortcut(Key.ENTER);
        transferToEmployee.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(add, delete, transferToEmployee,createAbschreibung);
    }

    /**
     * Setzt die Aktionen für die Buttons;
     */
    private void configureButtonActions(){
        //Delete Button
        delete.addClickListener(clickEvent -> {
           artikelLogic.deleteArtikel(homeView.getArtikelGrid().getSelectedArtikel());
            homeView.getArtikelGrid().getGrid().setItems(artikelLogic.getUserArtikel(1).getArtikelListe());
        });

        //Abschreibung Button
        createAbschreibung.addClickListener(buttonClickEvent -> {
            abschreibungLogic = new AbschreibungLogic();
            for(Artikel artikel : homeView.getArtikelGrid().getGrid().getSelectedItems()){
                abschreibungLogic.createAbschreibung(artikel);
            }
        });

        //Übergabe an Mitarbeiter Button
        transferToEmployee.addClickListener(clickEvent -> {
            Label statusLabel = homeView.getStatusLabel();
            if(!employeeName.getValue().isEmpty()) {
                for (Artikel artikel : homeView.getArtikelGrid().getSelectedArtikel()) {
                    artikel.setMitarbeiterName(employeeName.getValue());
                }
                statusLabel.setVisible(false);
                homeView.getEmployeeGrid().getGrid().setItems(homeView.getArtikelGrid().getSelectedArtikel());
                employeeName.clear();
            }else{
                statusLabel.setVisible(true);
                statusLabel.setText("Bitte gebe einen Mitarbeitername an.");
            }
        });

        add.addClickListener(buttonClickEvent -> {
            Label formstatusLabel = homeView.getStatusLabel();
            if (!artikel_name.getValue().isEmpty() && !anzahl.getValue().isEmpty() && preis.getValue() != null && kaufdatum.getValue() != null) {
                artikelLogic.saveArtikel(new Artikel(1L, artikel_name.getValue(), Integer.valueOf(anzahl.getValue()), Double.valueOf(preis.getValue()), kaufdatum.getValue()));
                formstatusLabel.setVisible(false);
                homeView.getArtikelGrid().getGrid().setItems(artikelLogic.getUserArtikel(1).getArtikelListe());
            }else{
                formstatusLabel.setVisible(true);
                formstatusLabel.setText("Bitte befüllen Sie alle felder");
            }
        });
    }

    //Getter & Setter
    public FormLayout getArtieklForm() {
        return artieklForm;
    }
}
