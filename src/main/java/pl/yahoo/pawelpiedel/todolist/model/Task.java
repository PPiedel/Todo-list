package pl.yahoo.pawelpiedel.todolist.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Pawel_Piedel on 25.12.2017.
 */
@Entity
@Table(name = "Tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String description;
    @ManyToOne
    @JoinColumn(name = "User")
    private User user;
    @ManyToOne
    @JoinColumn(name = "TodoList")
    private TodoList todoList;

    //required by Hibernate
    protected Task() {}

    public Task(String label, String description, User user, TodoList todoList) {
        this.label = label;
        this.description = description;
        this.user = user;
        this.todoList = todoList;
    }
}
