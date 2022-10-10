package by.step.test.security;

import by.step.test.excemption.ErrorDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// - класс ОБРАБОТЧИК ОШИБОК  ентри поинтов
@Component
@Slf4j
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
//  -  AuthenticationEntryPoint is used to send an HTTP response that
//  requests credentials from a client.
//    - "Пройдите аутентиф-ю"

// - проброс ОШИБКИ - при обращении к заблоченному ресурсу, ДО Контроллера
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setDetails("Пройдите аутентиф-ю");
//        ErrorDetails.builder()...
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), errorDetails);
        // todo------description of esc - ошибок
    }
}
