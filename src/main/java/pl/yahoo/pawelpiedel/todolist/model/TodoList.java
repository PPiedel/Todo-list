package pl.yahoo.pawelpiedel.todolist.model;

import javax.persistence.*;

/**
 * Created by Pawel_Piedel on 25.12.2017.
 */
@Entity
@Table(name = "TodoLists")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public TodoList() {
    }

    public TodoList(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
