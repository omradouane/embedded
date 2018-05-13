package com.oradouane.content.gui;

import com.oradouane.content.gui.ui.util.ResponsivenessListener;
import com.vaadin.spring.server.SpringVaadinServlet;

import javax.servlet.ServletException;

public class CustomVaadinServlet extends SpringVaadinServlet {

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new ResponsivenessListener());
    }

}