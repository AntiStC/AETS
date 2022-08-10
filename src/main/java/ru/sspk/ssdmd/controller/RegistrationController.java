package ru.sspk.ssdmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sspk.ssdmd.model.RegistrationForm;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(
            UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        UserDto userDto = form.toUserDto(passwordEncoder);
        userService.save(userDto);
        return "redirect:/login";
    }

}
