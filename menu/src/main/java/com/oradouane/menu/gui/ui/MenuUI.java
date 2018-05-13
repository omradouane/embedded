package com.oradouane.menu.gui.ui;

import com.oradouane.menu.gui.ui.view.MainMenuView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@Theme(ValoTheme.THEME_NAME)
@SpringUI//(path = "/menu")
@Title("Menu")
//@Push
public class MenuUI extends UI {

    private final MainMenuView mainMenuView;

    @Autowired
    public MenuUI(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setContent(mainMenuView);
        //setContent(new Label("Hello menu"));
    }
}
