package com.yumm.recipe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.yumm.recipe.entities.User;
import com.yumm.recipe.service.UserService;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter  {

	@Autowired
    private UserService service;

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**","/swagger-ui/**");
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
       
        http.formLogin()
                .defaultSuccessUrl("/recipes/")
            .and()
                .logout()
                .permitAll()
            .and()
                .authorizeRequests()
                .antMatchers("/**").hasRole("USER")
        ;
        
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(service);

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ApplicationRunner initializeUsers(final PasswordEncoder passwordEncoder) {

        final User defaultUser = new User("divya", passwordEncoder.encode("welcome@123"));

        return args -> service.save(defaultUser);
    }    
}
