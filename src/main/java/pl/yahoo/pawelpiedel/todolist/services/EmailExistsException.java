package pl.yahoo.pawelpiedel.todolist.services;

public class EmailExistsException extends Exception {
    public EmailExistsException(String message) {
        super(message);
    }
}
