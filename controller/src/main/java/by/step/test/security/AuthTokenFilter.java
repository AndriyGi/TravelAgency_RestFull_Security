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
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            //-парсируем, спользую метод  -parseJwt
            String jwt = parseJwt(request);
            //-проверяем используя наш метод - validateJwtToken(проверка на время) из JwtUtill
            if (jwt != null && jwtUtill.validateJwtToken(jwt)) {
                //    из jwt - вытягиваем -username(mail)
                String username = jwtUtill.getUserNameFromToken(jwt);
// - создвем(загружаем) объект userDetails (типа-GrantedAuthority)
//           по найденному -username(кот уже АВТОРИЗОВАН)
//-loadUserByUsername(username) - подтягиваем ВСЕГО (общего) пользователя по его -username(mail)
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // - создает объект типа -GrantedAuthority(общий интерфейс)
                //-сюда закидываем только его(userDetails) - ДОСТУП
    //-создаем его ДАННЫЕ, кот. будем закидывать в SecurityContextHolder(метод(-сто) доступа),
                // чтобы потом по этим своим доступам он мог обращаться к разным методам
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext()
                        .setAuthentication(usernamePasswordAuthenticationToken);
            }
        } catch (Exception e) {
            log.error("ERROR in Security FILTER ");
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);

    }

    //  - метод ля парсинга
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
