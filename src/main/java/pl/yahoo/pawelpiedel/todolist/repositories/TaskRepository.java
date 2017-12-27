package pl.yahoo.pawelpiedel.todolist.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.yahoo.pawelpiedel.todolist.model.Task;

import java.util.List;

/**
 * Created by Pawel_Piedel on 26.12.2017.
 */
public interface TaskRepository extends CrudRepository<Task,Long> {
}
