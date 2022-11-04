package by.step.test.excemption;

import by.step.test.exception.ExcEmptyHumansList;
import by.step.test.exception.ExcHumanNotFound;
import by.step.test.exception.ExcVaucherNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Date;
import java.time.Instant;

@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ControllerExcemtion.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails ServExcHumanIsInDataBase(ControllerExcemtion controllerExcemtion) {
        controllerExcemtion.printStackTrace();
        return ErrorDetails.builder()
                .timestamp(Date.from(Instant.now()))
                .message(controllerExcemtion.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST).details(" details " +
                        "- ServExcHumanIsInDataBase ").build();
    }

    @ExceptionHandler(ExcEmptyHumansList.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ErrorDetails ServExcNoHumansInDataB(ExcEmptyHumansList excEmptyHumansList) {
        return ErrorDetails.builder().timestamp((Date.from(Instant.now())))
                .message(excEmptyHumansList.getMessage())
                .httpStatus(HttpStatus.NO_CONTENT).details("details " +
                        "- ServExcNoHumansInDataB").build();
    }

    @ExceptionHandler(ExcHumanNotFound.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorDetails ServiceExceptionHumanNotFound(
            ExcHumanNotFound excHumanNotFound) {
        return ErrorDetails.builder().
                timestamp((Date.from(Instant.now()))).message(excHumanNotFound.getMessage())
                .httpStatus(HttpStatus.I_AM_A_TEAPOT).details("details " +
                        "- ServiceExceptionHumanNotFound")
                .build();

    }
    @ExceptionHandler(ExcVaucherNotFound.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorDetails HandlerVaucherIsNotFound(ExcVaucherNotFound excVaucherNotFound) {
        return ErrorDetails.builder().
                timestamp((Date.from(Instant.now())))
                .message(excVaucherNotFound.getMessage())
                .httpStatus(HttpStatus.I_AM_A_TEAPOT)
                .details("VAUCHER IS NOT FOUND")
                .build();

    }
}
