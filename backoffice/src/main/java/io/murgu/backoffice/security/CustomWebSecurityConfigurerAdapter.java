package io.murgu.backoffice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter {

    @Value("${security.enabled}")
    private boolean securityEnabled;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        if (securityEnabled) {
            return (web) -> {};
        } else {
            return (web) -> web.ignoring()
                    .requestMatchers(new AntPathRequestMatcher("/**"));
        }
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(
                new CustomFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }
}
