package by.step.test.service;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.security.JwtResponce;
import by.step.test.dao.entity.security.LoginRequest;
import by.step.test.dao.entity.security.SignUpRequest;
import by.step.test.exception.ExcHumanIsPresent;
import by.step.test.exception.ExcHumanNotFound;

public interface IAuthService {

    Human registration(SignUpRequest signUpRequest)
            throws ExcHumanNotFound, ExcHumanIsPresent;

    JwtResponce authentication(LoginRequest loginRequest);

}
