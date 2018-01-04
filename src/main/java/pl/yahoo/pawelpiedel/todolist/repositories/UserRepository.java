package pl.yahoo.pawelpiedel.todolist.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.yahoo.pawelpiedel.todolist.model.User;

/**
 * Created by Pawel_Piedel on 26.12.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String username);
}
