package com.iu.application.views;

import com.iu.application.entity.User;
import com.iu.application.logic.ArtikelLogic;
import com.iu.application.logic.UserLogic;
import com.iu.application.services.ArtikelService;
import com.iu.application.views.list.ArtikelForm;
import com.iu.application.views.list.ArtikelGrid;
import com.iu.application.views.list.EmployeeGrid;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("home")
@Route(value = "home",layout = MainLayout.class)
public class HomeView extends VerticalLayout implements HasUrlParameter<String> {
    private final UserLogic loginLogic;
    private final ArtikelLogic artikelLogic;

    private ArtikelGrid artikelGrid;
    private ArtikelForm artikelForm;
    private EmployeeGrid employeeGrid;

    @Autowired
    public HomeView(UserLogic loginLogic, ArtikelLogic artikelLogic) {
        this.loginLogic = loginLogic;
        this.artikelLogic = artikelLogic;

        artikelGrid = new ArtikelGrid(this);
        employeeGrid = new EmployeeGrid(this);
        artikelForm = new ArtikelForm(this,artikelLogic);


        this.setSizeFull();
        add(configureLayouts());
    }

    private VerticalLayout configureLayouts(){
        HorizontalLayout grids = new HorizontalLayout(artikelGrid.getGrid(), employeeGrid.getGrid());
        grids.setFlexGrow(1, artikelGrid.getGrid());
        grids.setFlexGrow(1, employeeGrid.getGrid());
        grids.setSizeFull();

        VerticalLayout fullLayout = new VerticalLayout(grids,artikelForm.getArtieklForm());
        fullLayout.setSizeFull();
        return fullLayout;
    }

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
}
