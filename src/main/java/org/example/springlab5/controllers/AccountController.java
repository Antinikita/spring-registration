package org.example.springlab5.controllers;

import jakarta.validation.Valid;
import org.example.springlab5.models.RegisterDto;
import org.example.springlab5.models.User;
import org.example.springlab5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class AccountController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("success",false);
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model,
                           @Valid @ModelAttribute RegisterDto registerDto,
                           BindingResult result) {
        if(!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(new FieldError("registerDto","confirmPassword","Password and Confirm Password do not match"));
        }
        User user = userRepository.findByEmail(registerDto.getEmail());
        if(user != null) {
            result.addError(new FieldError("registerDto","email","Email already exists"));
        }
        if(result.hasErrors()) {
            return "register";
        }
        try {
            var bCryptEncoder=new BCryptPasswordEncoder();
            User user1 = new User();
            user1.setFirst_name(registerDto.getFirstName());
            user1.setLast_name(registerDto.getLastName());
            user1.setEmail(registerDto.getEmail());
            user1.setPassword(bCryptEncoder.encode(registerDto.getPassword()));
            user1.setRegistration_date(new Date());
            userRepository.save(user1);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success",true);

        }
        catch (Exception ex){
            result.addError(new FieldError("registerDto","firstName",ex.getMessage()));
        }
        return "register";

    }
}
