package pl.yahoo.pawelpiedel.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.yahoo.pawelpiedel.todolist.dto.UserDto;
import pl.yahoo.pawelpiedel.todolist.model.User;
import pl.yahoo.pawelpiedel.todolist.services.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult, Errors errors) {
        System.out.println(userDto.toString());

        User existing = userService.findByUsername(userDto.getEmail());


        if (existing == null) {
            userService.saveUser(userDto);
        }

        return "index";

    }

}
