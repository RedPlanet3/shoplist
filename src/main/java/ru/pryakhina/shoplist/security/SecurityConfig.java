package ru.pryakhina.shoplist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        prePostEnabled = true,
//        securedEnabled = true,
//        jsr250Enabled = true)
@Configuration
public class SecurityConfig  {
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password(" ")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("Elena")
//                        .password("Elena")
//                        .roles("Admin", "Owner"))
//                .withUser(userBuilder.username("admin")
//                        .password("admin")
//                        .roles("Admin"))
//                .withUser(userBuilder.username("Guest")
//                        .password("Guest")
//                        .roles("Guest"));
//    }
}
