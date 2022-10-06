package by.step.test.exception;

public class ExcHumanOrVaucherNotExist extends Exception{

    public ExcHumanOrVaucherNotExist() {
    }

    public ExcHumanOrVaucherNotExist(String message) {
        super(message);
    }

    public ExcHumanOrVaucherNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcHumanOrVaucherNotExist(Throwable cause) {
        super(cause);
    }
}
