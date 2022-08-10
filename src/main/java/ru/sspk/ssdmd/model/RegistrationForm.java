package ru.sspk.ssdmd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.model.dto.RoleUserDto;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.entity.RoleUser;
import ru.sspk.ssdmd.service.RoleUserService;
import ru.sspk.ssdmd.service.UserService;
import ru.sspk.ssdmd.service.impl.RoleUserServiceImpl;
import ru.sspk.ssdmd.service.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class RegistrationForm {

    private UserService userService;

    private RoleUserService roleUserService;

    @Autowired
    public RegistrationForm(UserService userService, RoleUserService roleUserService) {
        this.userService = userService;
        this.roleUserService = roleUserService;
    }

    private String username;
    private String password;

    private String fullname;

    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto toUserDto(PasswordEncoder passwordEncoder) {
        return new UserDto.Builder().setLogin(username).setPassword(passwordEncoder.encode(password)).build();
    }

}
