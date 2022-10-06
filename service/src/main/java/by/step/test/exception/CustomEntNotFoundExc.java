package by.step.test.exception;

public class CustomEntNotFoundExc extends Exception{

    public CustomEntNotFoundExc() {
    }

    public CustomEntNotFoundExc(String message) {
        super(message);
    }

    public CustomEntNotFoundExc(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomEntNotFoundExc(Throwable cause) {
        super(cause);
    }
}
