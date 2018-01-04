package pl.yahoo.pawelpiedel.todolist.services;

import pl.yahoo.pawelpiedel.todolist.dto.UserDto;
import pl.yahoo.pawelpiedel.todolist.model.User;

public interface UserService {

    User findByEmail(String email);

    User registerNewUser(UserDto user) throws EmailExistsException;
}
