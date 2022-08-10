package ru.sspk.ssdmd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.mapper.UserMapper;
import ru.sspk.ssdmd.security.jdbc.UserDetail;
import ru.sspk.ssdmd.service.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests()
//                .antMatchers("/main").access("hasRole('USER')")
//                .antMatchers("/test").access("hasRole('USER')")
//                .antMatchers("/admin").access("hasRole('ADMIN')")
//                .antMatchers("/registration").access("permitAll()")
//                .antMatchers("/").access("permitAll()")
//                .antMatchers("/**").access("permitAll()")
//                .and()
//                .formLogin()
//                .successForwardUrl("/main")
//                .and()
//                .build();
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //DataBase Authentication
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());

        // LDAP auth
        auth.ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("userPassword");
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return username -> {
            UserDto userDto = userService.findByLogin(username);
            if (userDto != null) {
                UserDetail user = new UserDetail(UserMapper.toEntity(userDto));
                return user;
            }
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        };
    }

}
