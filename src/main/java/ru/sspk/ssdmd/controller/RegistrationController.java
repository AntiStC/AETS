package ru.sspk.ssdmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sspk.ssdmd.model.RegistrationForm;
import ru.sspk.ssdmd.model.dto.RoleUserDto;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.service.RoleUserService;
import ru.sspk.ssdmd.service.UserService;

import java.util.Arrays;
import java.util.Set;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    private RoleUserService roleUserService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(
            UserService userService, RoleUserService roleUserService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleUserService = roleUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        UserDto userDto = form.toUserDto(passwordEncoder);
        RoleUserDto roleUserDto = roleUserService.findByName("ROLE_USER");
        if (null == roleUserDto) {
            roleUserDto = new RoleUserDto.Builder().setName("ROLE_USER").build();
            roleUserDto = roleUserService.save(roleUserDto);
        }
        userDto.setRoles(Set.of(roleUserDto));
        userService.save(userDto);
        return "redirect:/login";
    }

}
