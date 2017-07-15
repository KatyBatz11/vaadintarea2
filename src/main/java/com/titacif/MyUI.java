package com.titacif;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;


import javax.servlet.annotation.WebServlet;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.titacif.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //layout principal
        final VerticalLayout layout = new VerticalLayout();
        //layout que contiene los bloques de ingreso
        final HorizontalLayout layoutHexterior = new HorizontalLayout();
        //layout que tiene los textfields de ingreso
        final HorizontalLayout layoutEspecialista = new HorizontalLayout();
        final HorizontalLayout layoutDeportista = new HorizontalLayout();
        //layout que contiene el despliegue de información
        final HorizontalLayout layoutHorizontal1 = new HorizontalLayout();

        final VerticalLayout layoutVertical1 = new VerticalLayout();
        final VerticalLayout layoutVertical2 = new VerticalLayout();

        final VerticalLayout layoutDatosE = new VerticalLayout();
        final VerticalLayout layoutDatosD = new VerticalLayout();

        layout.addComponent(new Label("Programa de Deportes"));

        /***************Especialista**********************/

        layout.addComponent(new Label ("  Ingreso de Datos "));
        final TextField nombre = new TextField();
        nombre.setCaption("Nombre");

        final TextField experiencia = new TextField();
        experiencia.setCaption(" Experiencia ");


        Button ingresoEspecialista = new Button("Ingresar");
        ingresoEspecialista.addClickListener( e -> {


            layoutVertical1.addComponent(new Label(" Especialista " + nombre.getValue()+"            "+ experiencia.getValue()));
                        nombre.clear();
            experiencia.clear();
            layoutDatosE.addComponent(new Label ("......................."));
        });

       /*********************DEPORTISTA*****************************************/

        //layoutDeportista.addComponent(new Label ("Ingreso de Deportista"));
        final TextField nombreDeportista = new TextField();
        nombreDeportista.setCaption("Nombre");

        final TextField edadDeportista = new TextField();
        edadDeportista.setCaption(" Edad: ");


        Button ingresoDeportista= new Button("Ingresar: ");
        ingresoDeportista.addClickListener( e -> {


            layoutVertical2.addComponent(new Label("Deportista :  " + nombreDeportista.getValue()+"      "+ edadDeportista.getValue()));
            nombreDeportista.clear();
            edadDeportista.clear();
            layoutDatosD.addComponent(new Label("....................."));


        });


        /**************************************************************/
        layout.addComponents(layoutHexterior, layoutHorizontal1);

        layoutHexterior.addComponents( layoutEspecialista, layoutDeportista);
        layoutEspecialista.addComponents( nombre, experiencia, ingresoEspecialista);
        layoutDeportista.addComponents( nombreDeportista, edadDeportista, ingresoDeportista);

        layoutHorizontal1.addComponents(layoutVertical1, layoutDatosE, layoutDatosD, layoutVertical2);



        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
