package pl.yahoo.pawelpiedel.todolist.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.yahoo.pawelpiedel.todolist.model.User;

/**
 * Created by Pawel_Piedel on 26.12.2017.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
