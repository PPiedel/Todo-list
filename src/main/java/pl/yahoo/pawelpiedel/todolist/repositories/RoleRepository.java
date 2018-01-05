package pl.yahoo.pawelpiedel.todolist.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.yahoo.pawelpiedel.todolist.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
