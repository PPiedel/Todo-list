package pl.yahoo.pawelpiedel.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.yahoo.pawelpiedel.todolist.dto.UserDto;
import pl.yahoo.pawelpiedel.todolist.model.Role;
import pl.yahoo.pawelpiedel.todolist.model.User;
import pl.yahoo.pawelpiedel.todolist.repositories.UserRepository;

import java.util.Collections;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public User registerNewUser(UserDto userDto) throws EmailExistsException {
        User user = null;
        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + userDto.getEmail());
        } else {
            user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            user.setRoles(Collections.singletonList(new Role("ROLE_USER")));
        }

        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }
}
