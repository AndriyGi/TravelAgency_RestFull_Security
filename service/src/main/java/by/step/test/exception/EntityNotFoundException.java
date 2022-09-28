package by.step.test.exception;

import by.step.test.dto.VaucherDto;

import java.util.List;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public void test(){

    }
}
