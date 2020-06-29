package com.example.UserRegistration.Controller;

import com.example.UserRegistration.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/")
    public String home(Model model){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
