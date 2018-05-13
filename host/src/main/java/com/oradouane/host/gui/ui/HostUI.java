package com.oradouane.host.gui.ui;

import com.oradouane.host.gui.ui.view.MainHostView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@Theme(ValoTheme.THEME_NAME)
@SpringUI(path = "/")
@Title("Host")
//@Push
public class HostUI extends UI {

    private MainHostView mainHostView;
    private BrowserFrame contentFrame;

    public HostUI() {
        System.out.println("new UI");
    }

    //@Autowired
    public HostUI(MainHostView mainHostView) {
        this.mainHostView = mainHostView;
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        addFunctions();
        //setContent(mainView);
        //setContent(new Label("Hello host"));

        HorizontalLayout layout = new HorizontalLayout();
        final BrowserFrame menuFrame = new BrowserFrame("Menu", new ExternalResource("http://localhost:8001"));
        menuFrame.setWidth("30%");
        menuFrame.setHeight("400px");
        layout.addComponent(menuFrame);

        contentFrame = new BrowserFrame("content", new ExternalResource("http://localhost:8002"));
        contentFrame.setWidth("10%");
        contentFrame.setHeight("400px");
        contentFrame.setId("contentFrame");
        layout.addComponent(contentFrame);
        setContent(layout);
    }

    private void addFunctions() {
        JavaScript.getCurrent().execute("enableCO();");
    }
}
