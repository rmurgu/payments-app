package io.murgu.backoffice.security.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

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

}
