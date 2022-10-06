package by.step.test.service;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.security.JwtResponce;
import by.step.test.dao.entity.security.LoginRequest;
import by.step.test.dao.entity.security.SignUpRequest;

public interface AuthService {

    Human registration(SignUpRequest signUpRequest);

    JwtResponce authentication(LoginRequest loginRequest);

}
