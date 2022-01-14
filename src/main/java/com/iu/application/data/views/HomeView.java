package com.iu.application.data.views;

import com.iu.application.data.views.list.ArtikelListe;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@PageTitle("home")
@Route(value = "officemanager.com/home")
public class HomeView extends AppLayout {


    public HomeView() {
        createHeader();
        createDrawer();
        createFooter();

    }

    private void createFooter() {

    }

    private void createHeader() {
        H1 logo = new H1("Officemanager");
        logo.addClassNames("text-l", "m-m");

        Button kontakt = new Button("Kontakt");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, kontakt);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Artikel", ArtikelListe.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                listLink,
                new RouterLink("...", HomeView.class)
        ));

    }

}
