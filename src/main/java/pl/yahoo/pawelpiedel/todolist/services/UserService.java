package pl.yahoo.pawelpiedel.todolist.services;

import pl.yahoo.pawelpiedel.todolist.dto.UserDto;
import pl.yahoo.pawelpiedel.todolist.model.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(UserDto user);
}
