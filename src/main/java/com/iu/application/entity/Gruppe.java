package com.iu.application.entity;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("officemanager.com/Gruppen")
public class Gruppe extends Div {

    private String name;

    public Gruppe() {
        ComboBox<String> gruppen = new ComboBox<>("Gruppen");
        gruppen.setAllowCustomValue(true);
        add(gruppen);
        gruppen.setItems("Elekrogeräte", "Schreibwaren", "Möbel");
        gruppen.setHelperText("Wählen Sie eine Gruppe aus");
    }
}
