package pl.yahoo.pawelpiedel.todolist.model;

/**
 * Created by Pawel_Piedel on 25.12.2017.
 */

public class Task {
    private Long id;
    private String label;
    private String description;

    private User user;
    private TodoList todoList;

    protected Task() {

    }

    public Task(String label, String description, User user, TodoList todoList) {
        this.label = label;
        this.description = description;
        this.user = user;
        this.todoList = todoList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}
