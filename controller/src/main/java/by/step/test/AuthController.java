package by.step.test;


import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.security.JwtResponce;
import by.step.test.dao.entity.security.LoginRequest;
import by.step.test.dao.entity.security.SignUpRequest;
import by.step.test.exception.ExcHumanIsPresent;
import by.step.test.exception.ExcHumanNotFound;
import by.step.test.security.UserDetailsImpl;
import by.step.test.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
@Tag(name = "ПРОВЕРКА", description = "для АВТОРИЗАЦИИ")
public class AuthController {

    private final IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registr")
    @Operation(summary = "Зарегестрировать нового Человека", description = "registration")
    public Human registration(@RequestBody SignUpRequest signUpRequest)
            throws ExcHumanNotFound, ExcHumanIsPresent {
        Human human = authService.registration(signUpRequest);
        return human;
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Идентифицировать  Человека", description = "authentication")
    public JwtResponce authentication(@RequestBody LoginRequest loginRequest) {
        JwtResponce jwtResponce = authService.authentication(loginRequest);
        return jwtResponce;
    }

    @GetMapping("/authentificated")
    public String pageForeAuthentificatedUsers(Principal principal) {
        UserDetailsImpl a = (UserDetailsImpl) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return "secured part of web service" + a.getName();
    }

}
