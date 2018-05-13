package com.oradouane.content.gui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableOAuth2Sso
@Configuration
public class ContentWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable() // Disable CSRF
                .authorizeRequests().anyRequest().authenticated() // User must be authenticated
        ;
        // @formatter:on
    }

}
