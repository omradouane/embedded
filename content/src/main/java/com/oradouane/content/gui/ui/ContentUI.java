package com.oradouane.content.gui.ui;

import com.oradouane.content.gui.ui.view.MainContentView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@Theme(ValoTheme.THEME_NAME)
@SpringUI//(path = "/content")
@Title("content")
//@Push
public class ContentUI extends UI {

    private MainContentView mainContentView;

    public ContentUI(){

    }


    @Autowired
    public ContentUI(MainContentView mainContentView) {
        this.mainContentView = mainContentView;
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setContent(mainContentView);
        //setContent(new Label("Hello content"));
    }
}
