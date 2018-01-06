package pl.yahoo.pawelpiedel.todolist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.yahoo.pawelpiedel.todolist.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @RequestMapping(value = "/login/error", method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("error", true);
        return "login";
    }

    @RequestMapping(value = "/login/success", method = RequestMethod.GET)
    public String loginSuccess(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("Login success");

        model.addAttribute("user", new UserDto());
        model.addAttribute("success", true);

        return "login";
    }


    @RequestMapping(value = "/logout/succesfull", method = RequestMethod.GET)
    public String logoutSuccesfull(Model model) {
        System.out.println("Logout success");
        logger.info("Jestem w logout success");

        model.addAttribute("user", new UserDto());
        model.addAttribute("logout", true);
        return "login";
    }


    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDenied() throws Exception {
        throw new Exception("Nie masz uprawnień aby wyświetlć tą stronę. Czy wpisany link jest poprawny?");
    }

}
