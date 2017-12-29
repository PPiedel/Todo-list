package pl.yahoo.pawelpiedel.todolist.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Pawel_Piedel on 25.12.2017.
 */
@Entity
@Table(name = "TodoLists")
@Data
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //required by Hibernate
    protected TodoList() {
    }

    public TodoList(String name) {
        this.name = name;
    }

}
