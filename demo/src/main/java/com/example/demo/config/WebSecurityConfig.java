package com.example.demo.config;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 /*  private UserService userService;
@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/coffee/add","/coffee/{id}/edit").authenticated()
                .anyRequest().permitAll()
                    .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                ;
    }
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                        .username("user")
                        .password("{bcrypt}$2a$12$AL01fiQetprrB0iODdx98Ol5cKZZ1Af3ADueVW.7zeZAMmReztDGa")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
    /*
    //In Memory
   @Bean

    public UserDetailsService users(){
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$U/XTPJbTftWMzi4GQowd4er.rUZK0RU8ZsrlWdKNRvkVed4IMO55e")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$U/XTPJbTftWMzi4GQowd4er.rUZK0RU8ZsrlWdKNRvkVed4IMO55e")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }



    @Bean
    public JdbcUserDetailsManager users (DataSource dataSource){
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$U/XTPJbTftWMzi4GQowd4er.rUZK0RU8ZsrlWdKNRvkVed4IMO55e")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$U/XTPJbTftWMzi4GQowd4er.rUZK0RU8ZsrlWdKNRvkVed4IMO55e")
                .roles("ADMIN")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        if (users.userExists(user.getUsername())){
            users.deleteUser(user.getUsername());
        }
        if (users.userExists(admin.getUsername())){
            users.deleteUser(admin.getUsername());
        }
        users.createUser(user);
        users.createUser(admin);
        return users;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);

        return authenticationProvider;
    }*/
}
