package com.example.UserRegistration.Controller;

import com.example.UserRegistration.model.User;
import com.example.UserRegistration.repository.UserRepository;
import com.example.UserRegistration.service.UserService;
import com.example.UserRegistration.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //returns new object of UserRegistrationDto
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    //returning registration form to user
    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }


    @GetMapping("/update/{id}")
    public  String updateUserInformation(@PathVariable("id") long id, @ModelAttribute("user") @Validated UserRegistrationDto userDto, BindingResult result,Model model){

        //saving the update information to the database
        userService.save(userDto);

        //displaying the updated information to the user
        model.addAttribute("user",this.userRepository.findById(id));
        return "update";

    }
    //fetching data for the specified user from the database for editing
    @GetMapping("/edit/{id}")
    public String editUserInformation(@PathVariable("id") long id, Model model) {
        User user = this.userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user id" + id));
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Validated UserRegistrationDto userDto,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }
}

