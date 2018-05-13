package com.oradouane.content.gui;

import com.oradouane.content.gui.ui.NavigationManager;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.Filter;
import java.util.Collections;


@SpringBootApplication
public class ContentGuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentGuiApplication.class, args);
    }

    @Bean
    @Primary
    public VaadinServlet vaadinServlet() {
        return new CustomVaadinServlet();
    }


    @Bean
    @Primary
    @UIScope
    public SpringNavigator vaadinNavigator() {
        return new NavigationManager();
    }

    //@Bean
    public Filter corsFilter(){
        return new CorsFilter(corsConfigurationSource());
    }

    private CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource corsConfigSource = new UrlBasedCorsConfigurationSource();
        corsConfigSource.registerCorsConfiguration("/**", corsConfiguration());
        return corsConfigSource;
    }

    private CorsConfiguration corsConfiguration() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(Collections.singletonList("*"));
        return cors;
    }
}
