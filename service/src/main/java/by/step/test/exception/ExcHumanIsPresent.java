package by.step.test.exception;


import by.step.test.dao.entity.Human;

public class ExcHumanIsPresent extends Exception {

    public ExcHumanIsPresent() {
    }

    public ExcHumanIsPresent(String message) {
        super(message);
    }

    public ExcHumanIsPresent(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcHumanIsPresent(String message, Human human) {
    }
}
