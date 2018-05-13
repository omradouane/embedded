package com.oradouane.menu.gui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableOAuth2Sso
@Configuration
public class MenuWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable() // Use Vaadin's CSRF protection
                .authorizeRequests().anyRequest().authenticated() // User must be authenticated to access any part of the application
        ;
        // @formatter:on
    }

}
