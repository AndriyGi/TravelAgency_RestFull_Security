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


// - класс ОБРАБОТЧИК ОШИБОК  внутри поинтов
@Component
@Slf4j
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
//  -  AuthenticationEntryPoint is used to send an HTTP response that
//  requests credentials from a client.
//   пример  - "Пройдите аутентиф-ю"

// - проброс ОШИБКИ - при обращении к заблоченному ресурсу, ДО Контроллера
    //- нужен - response - в него будем закидывать наши ДАННЫЕ, кот мы хотим вернуть
    @Override
    public void commence(
            // commence- МЕТОД для вызова В ТОМ случеа - когда валидация НЕдоступна
            // - этот метод как ControllerAdice   - только для СЕКЬЮРИТИ
            HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {
// - когда у нас запрещен доступ куда-то:  SC_UNAUTHORIZED (ошибка 401), что бы такой пришел ответ
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        log.info(" попытка   входа   НЕавторизованным пользователем  ");

// - создан Объект для закидывание в него через Сэттеры
        ErrorDetails errorDetails = new ErrorDetails();

//-то-же что и выше только из Хендлера - но туда запрос еще НЕ ПОПАЛ    ???
// - здесь мы НЕМОЖЕМ НИЧЕГО вернуть в -errorDetails
        errorDetails.setDetails("Пройдите аутентиф-ю"); // - Сэт - возвращает ВОИД-ничего, сэтает
//        ErrorDetails.builder()...  -  можно использовать Билдер(через класс. тк это СТАТИЧЕСКИЙ метод(паттерн))
//        - Билдер возвращает - ЭТОТ-ЖЕ объект

//  -ObjectMapper - это класс в пакете jackson-databind,
//   который предоставляет функцию чтения и записи JSON, который может легко преобразовывать ОБЪЕКТЫ(POJO) в JSON:
        // - ЗДЕСЬ он запишет -errorDetails  -В-  -response - это уйдет в ЭррорРеспонс
        // - response - объект (улетает на ФРОНТ как объект)
        // - НАШ -errorDetails.setDetails("Пройдите аутентиф-ю") - добавляется в ОБЩИЙ (HttpServletResponse response) -> на ФРОНТ
        // - выводиться будет в  -getOutputStream()
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), errorDetails);
        // todo------description of esc - ошибок
    }
}
