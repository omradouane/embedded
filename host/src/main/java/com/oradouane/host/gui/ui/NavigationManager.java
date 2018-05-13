package com.oradouane.host.gui.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.internal.Conventions;
import com.vaadin.spring.navigator.SpringNavigator;

@UIScope
public class NavigationManager extends SpringNavigator {

    private String getViewName(Class<? extends View> viewClass) {
        final SpringView springViewAnno = viewClass.getAnnotation(SpringView.class);
        if (springViewAnno == null) {
            throw new IllegalArgumentException("The target class should be annotated with @SpringView");
        }

        return Conventions.deriveMappingForView(viewClass, springViewAnno);
    }

    public void navigateTo(Class<? extends View> targetView) {
        String viewName = getViewName(targetView);
        navigateTo(viewName);
    }

    private void navigateToDefaultView() {
        //navigateTo(MediaPresenter.class);
    }

    @Override
    public void navigateTo(String navigationState) {
        if (navigationState == null || navigationState.isEmpty()) {
            navigateToDefaultView();
        } else {
            super.navigateTo(navigationState);
        }
    }

}
