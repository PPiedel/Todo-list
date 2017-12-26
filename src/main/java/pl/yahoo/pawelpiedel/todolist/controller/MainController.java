package pl.yahoo.pawelpiedel.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yahoo.pawelpiedel.todolist.model.User;

/**
 * Created by Pawel_Piedel on 26.12.2017.
 */
@RestController
public class MainController {
    @RequestMapping("/user")
    public User greeting() {
        return new User("test", "test");
    }
}
