package by.step.test.security;

import by.step.test.security.utill.JwtUtill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// - это ФИЛЬТР, желательно здесь БИН не создавать

//- запросы сначало попадают в фильтр
// -нужен для - при поступлении запросов, перед тем как их парсить,
// - здесь их можно  - видоизменить, валидировать, обработать

// ПОСЛЕ - запросы отправляются на СЕРВЛЕТ для парсинга и тд...
//  "Component здесь не нужен тк будет работать тк он находится в скане пакета
// и видит созданный Бин - AuthTokenFilter в классе - WebSecurityConfi
@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

    private final JwtUtill jwtUtill;
    public final UserDetailsServiceImpl userDetailsService;

    public AuthTokenFilter(
            JwtUtill jwtUtill,
            UserDetailsServiceImpl userDetailsService) {
        this.jwtUtill = jwtUtill;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            // - МЕТОД - ФИЛЬТРУЕТ по Токену, валиден-ли он?
            // - встроились в Цепочку фильтров(-doFilterInternal) для  добавления своего (логики)
            HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            //-парсируем(получаем Токен из request) , используюя метод  -parseJwt
            String jwt = parseJwt(request);
            //-проверяем используя наш метод - validateJwtToken(проверка на время) из JwtUtill
            if (jwt != null && jwtUtill.validateJwtToken(jwt)) {
                //    из jwt - вытягиваем(ПОЛУЧАЕМ) -username(mail)
                String username = jwtUtill.getUserNameFromToken(jwt);
//   ПОЛУЧАЕМ - userDetails  -  по найденному -username(кот. уже АВТОРИЗОВАН)
// - Достаем(загружаем) готовый объект userDetails (типа-GrantedAuthority)
//-loadUserByUsername(username) - подтягиваем ВСЕГО (общего) пользователя по его -username(mail)
                // - userDetails - ОБЫЧНЫЙ пользователь
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

// - создаем ОБЪЕКТ АУТЕНТИФИКАЦИИ с его ролями и всем остальным (типа -GrantedAuthority(общий интерфейс))
                //-сюда закидываем только его(userDetails) - ДОСТУП
//-создаем его ДАННЫЕ(в сгенеренный ранее(в JwtUtills)- ТОКЕН-?),
// кот. будем закидывать в SecurityContextHolder(метод доступа),
                // чтобы потом по этим своим Authority он мог обращаться к разным методам
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

//- создаем(? СЭТАЕМ) объект (Аутентификации) из -request - все данные в нем
//    (responce - здесь приходит пустым, его потом будем отправлять)
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

// и кладем в SecurityContextHolder,
// который использ-ся в методе -authentication в IAuthServiceImpl
                SecurityContextHolder.getContext()
                        .setAuthentication(usernamePasswordAuthenticationToken);
            }
        } catch (Exception e) {
            log.error("--- ERROR in Security FILTER --");
            e.printStackTrace();
        }
        // - продлеваем Цепочку фильтров дальше, для -продолжения фильтрования по дефолту
        filterChain.doFilter(request, response);

    }

    //  - метод для парсинга
    // - private - тк будем его вызывать только из метода здесь - doFilterInternal
    // - HttpServletRequest -запрос - то что приходит с ФРОНТа(с Свагера, Постмана...)
    // - парсить - убирать Header в начале (заголовок над Характеристиками ЗАПРОСА)
    // -чтобы получить - Token  (для работы с ним)- без его типа
    private String parseJwt(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String jwtToken = null;
        // - если есть заголовок, под КЛЮЧЕМ - "Authorization" и
        // этот заголовок начинается с  "Bearer" - тип Токена
        if (StringUtils.hasText(header) && header.startsWith("Bearer")) {
            // - получили ТОКЕН (jwtToken) для работы с ним, откинув 6 чисел- (Bearer)
            jwtToken = header.substring(7);
        }
        return jwtToken;
    }
}
