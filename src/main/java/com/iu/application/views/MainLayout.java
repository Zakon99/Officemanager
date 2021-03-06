package com.iu.application.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

/**
 * Klasse für das MainLayout
 * @author Hari Rait
 */
@PageTitle("home")
@Route(value = "mainlayout")
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    /**
     * Erstellt den Header für das MainLayout
     */
    private void createHeader() {
        H1 logo = new H1("Officemanager");
        logo.addClassNames("text-l", "m-m");

        Button logout = new Button("Logout");
        logout.addClickListener(event -> {
            UI.getCurrent().navigate(LoginView.class);
        });

        Button kontakt = new Button("Kontakt");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout, kontakt);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        addToNavbar(header);
    }

    private void createDrawer() {
        Button artikel = new Button("Arikel");
        Button mitarbeiter = new Button("Mitarbeiter");
        Button  soon = new Button("commin soon...");

        artikel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        mitarbeiter.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        soon.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        addToDrawer(new VerticalLayout(
                artikel, mitarbeiter, soon

        ));
    }
}
