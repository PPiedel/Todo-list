package pl.yahoo.pawelpiedel.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.yahoo.pawelpiedel.todolist.dto.UserDto;
import pl.yahoo.pawelpiedel.todolist.model.User;
import pl.yahoo.pawelpiedel.todolist.services.EmailExistsException;
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

    @RequestMapping(value = "/registerSuccess", method = RequestMethod.GET)
    public String registerSuccess(Model model) {
        System.out.println("Jestem w register success");
        model.addAttribute("registerSucess", true);
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @RequestMapping(value = "/registerError", method = RequestMethod.GET)
    public String registerError(Model model) {
        model.addAttribute("registerError", true);
        model.addAttribute("user", new UserDto());
        return "login";
    }


    @PostMapping(value = "/register")
    public String register(@ModelAttribute("user") @Valid UserDto userDto) {
        User registered = createUserAccount(userDto);

        if (registered != null) {
            System.out.println(registered.toString());
            return "redirect:/registerSuccess";

        } else {
            return "redirect:/registerError/";
        }
    }

    private User createUserAccount(UserDto userDto) {
        User registered;
        try {
            registered = userService.registerNewUser(userDto);
        } catch (EmailExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return registered;
    }

}
