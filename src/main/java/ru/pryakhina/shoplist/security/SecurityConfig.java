//package ru.pryakhina.shoplist.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(
////        prePostEnabled = true,
////        securedEnabled = true,
////        jsr250Enabled = true)
///**
// * Конфигурация для настройки Spring Security
// * @author elena
// */
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public DataSource dataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }
//
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password(" ")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
////        http.authorizeRequests()
////                .anyRequest("/").hasAnyRole("ADMIN", "USER")
////                .anyRequest("/roles").hasRole("ADMIN")
////                .and().formLogin().permitAll();
////
////        return http.build();
////    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource());
//    }
//}
