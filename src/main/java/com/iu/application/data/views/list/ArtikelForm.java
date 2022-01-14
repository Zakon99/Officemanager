package com.iu.application.data.views.list;

import com.iu.application.data.entity.Artikel;
import com.iu.application.data.entity.Gruppe;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

import java.awt.*;
import java.util.List;
import java.util.Locale;

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
