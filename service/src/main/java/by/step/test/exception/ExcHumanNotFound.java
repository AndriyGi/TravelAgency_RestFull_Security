package by.step.test.exception;

public class ExcHumanNotFound extends Exception {

    public ExcHumanNotFound() {
    }

    public ExcHumanNotFound(String message) {
        super(message);
    }

    public ExcHumanNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage(String human_not_foud_by_id) {
        return human_not_foud_by_id;
    }
}

