package com.iu.application.views;

import com.iu.application.logic.ArtikelLogic;
import com.iu.application.logic.UserLogic;
import com.iu.application.views.components.ArtikelForm;
import com.iu.application.views.components.ArtikelGrid;
import com.iu.application.views.components.EmployeeGrid;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Klasse für die HomeView
 * @author Hari Rait
 */
@PageTitle("home")
@Route(value = "home",layout = MainLayout.class)
public class HomeView extends VerticalLayout implements HasUrlParameter<String> {
    private final UserLogic userLogic;
    private final ArtikelLogic artikelLogic;

    //Components
    private ArtikelGrid artikelGrid;
    private ArtikelForm artikelForm;
    private EmployeeGrid employeeGrid;
    private Label statusLabel = new Label();

    @Autowired
    public HomeView(UserLogic userLogic, ArtikelLogic artikelLogic) {
        this.userLogic = userLogic;
        this.artikelLogic = artikelLogic;

        artikelGrid = new ArtikelGrid(this);
        employeeGrid = new EmployeeGrid(this);
        artikelForm = new ArtikelForm(this,artikelLogic);

        configureComponentStyles();
        this.setSizeFull();
        add(configureLayouts());
    }

    /**
     * Entnimmt die Parameter (userId) aus der URL und befüllt die Tabelle anhand der userId
     * @param beforeEvent
     * @param parameter
     */
    @Override
    public void setParameter(BeforeEvent beforeEvent,@OptionalParameter String parameter) {
        if(parameter == null || parameter.isEmpty()){
            //Pass User to Startpage
            UI.getCurrent().navigate(LoginView.class);
            UI.getCurrent().getPage().reload();
        }else{
            artikelGrid.getGrid().setItems(artikelLogic.getUserArtikel(Long.valueOf(parameter)).getArtikelListe());
        }
    }

    /**
     * Konfiguriert das Layout für die HomeView
     * @return Vollständiges Layout
     */
    private VerticalLayout configureLayouts(){
        HorizontalLayout grids = new HorizontalLayout(artikelGrid.getGrid(), employeeGrid.getGrid());
        grids.setFlexGrow(1, artikelGrid.getGrid());
        grids.setFlexGrow(1, employeeGrid.getGrid());
        grids.setSizeFull();

        VerticalLayout fullLayout = new VerticalLayout(grids,statusLabel,artikelForm.getArtieklForm());
        fullLayout.setSizeFull();
        return fullLayout;
    }

    /**
     * Konfiguriert die Component Styles
     */
    private void configureComponentStyles(){
        statusLabel.setVisible(false);
        statusLabel.getStyle().set("color","RED");
    }

    //Getter & Setter
    public ArtikelGrid getArtikelGrid() {
        return artikelGrid;
    }

    public void setArtikelGrid(ArtikelGrid artikelGrid) {
        this.artikelGrid = artikelGrid;
    }

    public EmployeeGrid getEmployeeGrid() {
        return employeeGrid;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }
}
