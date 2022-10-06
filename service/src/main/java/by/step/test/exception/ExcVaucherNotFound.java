package by.step.test.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus
public class ExcVaucherNotFound extends Exception {

    public ExcVaucherNotFound(String message) {
        super(message);
    }

    public ExcVaucherNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcVaucherNotFound(Throwable cause) {
        super(cause);
    }

    public ExcVaucherNotFound() {
    }

}
