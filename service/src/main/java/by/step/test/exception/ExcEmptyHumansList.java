package by.step.test.exception;

public class ExcEmptyHumansList extends  Exception{

    public ExcEmptyHumansList() {
    }

    public ExcEmptyHumansList(String message) {
        super(message);
    }

    public ExcEmptyHumansList(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcEmptyHumansList(Throwable cause) {
        super(cause);
    }
}
