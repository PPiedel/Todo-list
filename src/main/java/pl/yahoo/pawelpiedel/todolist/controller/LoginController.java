package pl.yahoo.pawelpiedel.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.yahoo.pawelpiedel.todolist.dto.UserDto;

@Controller
public class LoginController {

    /*@RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDto());
        return "login";
    }*/

    @RequestMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("error", true);
        return "login";
    }

    @RequestMapping("/login/success")
    public String loginSuccess(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("success", true);

        return "login";
    }


    @RequestMapping("/access-denied")
    public String accessDenied() throws Exception {
        throw new Exception("Nie masz uprawnień aby wyświetlć tą stronę. Czy wpisany link jest poprawny?");
    }

}
