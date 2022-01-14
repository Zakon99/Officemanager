package com.iu.application.views.list;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.List;

public class ArtikelForm extends FormLayout {

    NumberField userId = new NumberField("User Id");
    TextField name = new TextField("Name");
    ComboBox<String> gruppen = new ComboBox<>("Gruppen");
    TextField anzahl = new TextField("Anzahl");
    NumberField preis = new NumberField("Preis");
    DatePicker kaufdatum = new DatePicker("Kaufdatum");


    Button save = new Button("speichern");
    Button delete = new Button("löschen");
    Button close = new Button("schließen");

    public ArtikelForm(List<String> gruppen){
        addClassName("artikel-form");

        add(userId, name, anzahl, preis, kaufdatum,
            createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);

    }

}
