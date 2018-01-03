package pl.yahoo.pawelpiedel.todolist.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"pl.yahoo.pawelpiedel.todolist"})
@EntityScan(basePackages = {"pl.yahoo.pawelpiedel.todolist"})
@EnableJpaRepositories("pl.yahoo.pawelpiedel.todolist.repositories")
public class TodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }
}
