package com.example.demo.controlers;

import com.example.demo.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public class RegistrationController     {
    @GetMapping("/coffee/registration")
    public String showRegistration(WebRequest request, Model model  ){
        User user = new User();
        model.addAttribute("user",user);
        return "registration";
    }



}
