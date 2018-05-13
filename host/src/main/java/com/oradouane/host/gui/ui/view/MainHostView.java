package com.oradouane.host.gui.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@UIScope
@SpringViewDisplay
public class MainHostView extends HorizontalLayout implements ViewDisplay {

    private VerticalLayout content;

    public MainHostView() {
        setSizeFull();

        content = new VerticalLayout();
        content.setMargin(false);
        final VerticalLayout mainLayout = new VerticalLayout();
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
