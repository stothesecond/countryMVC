package com.example.mvcproj.config;

import com.example.mvcproj.service.CountryService;
import com.example.mvcproj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  CountryService countryService;

  UserService userService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/", "/about", "/register**", "/js/**", "/css/**", "/error/**").permitAll()
        .anyRequest().authenticated().and().formLogin().loginPage("/login").usernameParameter("user")
        .passwordParameter("pass").loginProcessingUrl("/processLoginCredentials").defaultSuccessUrl("/countries")
        .permitAll().and().logout().invalidateHttpSession(true).clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll().and();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    auth.setUserDetailsService(userService);
    auth.setPasswordEncoder(passwordEncoder());
    return auth;
  }

  @Autowired
  public void setCountryService(CountryService countryService) {
    this.countryService = countryService;
  }

  public CountryService getCountryService() {
    return countryService;
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public UserService getUserService() {
    return userService;
  }
}
