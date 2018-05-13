package com.oradouane.content.gui.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

@UIScope
@SpringViewDisplay
public class MainContentView extends HorizontalLayout implements ViewDisplay {

    private VerticalLayout content;

    public MainContentView() {
        setSizeFull();

        content = new VerticalLayout();
        content.setMargin(false);
        final VerticalLayout mainLayout = new VerticalLayout();
        content.addComponent(new Label("Hello from Content "));
        mainLayout.addComponents(content);
        mainLayout.setMargin(false);
        mainLayout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        addComponent(mainLayout);
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
    }

    @Override
    public void showView(View view) {
        content.removeAllComponents();
        content.addComponent(view.getViewComponent());
    }
}
