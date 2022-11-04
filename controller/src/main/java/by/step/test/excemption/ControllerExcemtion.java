package by.step.test.excemption;

public class ControllerExcemtion extends Exception {

    public ControllerExcemtion() {
    }

    public ControllerExcemtion(String message) {
        super(message);
    }

    public ControllerExcemtion(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerExcemtion(Throwable cause) {
        super(cause);
    }

}
