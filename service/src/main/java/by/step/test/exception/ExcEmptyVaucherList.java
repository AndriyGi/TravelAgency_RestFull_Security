package by.step.test.exception;

public class ExcEmptyVaucherList extends  Exception{

    public ExcEmptyVaucherList() {
    }

    public ExcEmptyVaucherList(String message) {
        super(message);
    }

    public ExcEmptyVaucherList(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcEmptyVaucherList(Throwable cause) {
        super(cause);
    }
}
