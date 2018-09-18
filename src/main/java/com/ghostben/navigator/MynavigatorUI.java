package com.ghostben.navigator;

import com.ghostben.view.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@Theme("mytheme")
public class MynavigatorUI extends UI {

    public static final String MAINVIEW = "main";
    public static final String HELPVIEW = "help";
    public static final String DRAGANDDROP = "dragdrop";
    public static final String COMPANYRATING = "rating";
    public Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        Navigator.ComponentContainerViewDisplay viewDisplay = new Navigator.ComponentContainerViewDisplay(layout);


        navigator = new Navigator(UI.getCurrent(), viewDisplay);
        navigator.addView("", new LoginView());
        navigator.addView(MAINVIEW, new MainView());
        navigator.addView(HELPVIEW, new HelpView());
        navigator.addView(DRAGANDDROP,new DragView());
        navigator.addView(COMPANYRATING,new CompanyRating());
    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MynavigatorUI.class)
    public static class Servlet extends VaadinServlet {
    }

}
