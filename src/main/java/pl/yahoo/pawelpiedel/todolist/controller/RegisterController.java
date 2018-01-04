package pl.yahoo.pawelpiedel.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.yahoo.pawelpiedel.todolist.dto.UserDto;
import pl.yahoo.pawelpiedel.todolist.model.User;
import pl.yahoo.pawelpiedel.todolist.services.EmailExistsException;
import pl.yahoo.pawelpiedel.todolist.services.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @RequestMapping(value = "/register/success", method = RequestMethod.GET)
    public String registerSuccess(Model model) {
        System.out.println("Jestem w register success");
        model.addAttribute("registerSucess", true);
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @RequestMapping(value = "/register/error", method = RequestMethod.GET)
    public String registerError(Model model) {
        model.addAttribute("registerError", true);
        model.addAttribute("user", new UserDto());
        return "register";
    }


    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") @Valid UserDto userDto) {
        System.out.println("Jestem w rejestracji!!!");
        User registered = createUserAccount(userDto);

        if (registered != null) {
            System.out.println(registered.toString());
            return "redirect:/register/success";

        } else {
            System.out.println("Registered is null");
            return "redirect:/register/error";
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
