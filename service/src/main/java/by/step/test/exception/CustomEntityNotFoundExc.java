package by.step.test.exception;

public class CustomEntityNotFoundExc extends Exception{

    public CustomEntityNotFoundExc() {
    }

    public CustomEntityNotFoundExc(String message) {
        super(message);
    }

    public CustomEntityNotFoundExc(String message, Throwable cause) {
        super(message, cause);
    }


}
