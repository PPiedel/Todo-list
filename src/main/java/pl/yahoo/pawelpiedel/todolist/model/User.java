package pl.yahoo.pawelpiedel.todolist.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Pawel_Piedel on 25.12.2017.
 */
@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    //required by Hibernate
    protected User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
