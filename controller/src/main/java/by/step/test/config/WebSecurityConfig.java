package by.step.test.config;

import by.step.test.security.AuthEntryPointJwt;
import by.step.test.security.AuthTokenFilter;
import by.step.test.security.UserDetailsServiceImpl;
import by.step.test.security.utill.JwtUtill;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtill jwtUtill;
    private final AuthEntryPointJwt authEntryPointJwt;


    public WebSecurityConfig(
            UserDetailsServiceImpl userDetailsService,
            JwtUtill jwtUtill,
            AuthEntryPointJwt authEntryPointJwt) {
        this.userDetailsService = userDetailsService;
        this.jwtUtill = jwtUtill;
        this.authEntryPointJwt = authEntryPointJwt;
    }

    // - создание бина для будущего использования в др классах
    @Bean
    public AuthTokenFilter authTokenFilter() {
        return new AuthTokenFilter(jwtUtill, userDetailsService);
    }

    // - создание бина для будущего использования в др классах
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
 //-cors - запрещает JS-скрипту одного сайта обращаться на др сайт без спец. разреш.
        http.cors()
                .and()
// - установка настроек, атака - csrf(исполььзование б/у Token-ов) - не разрешена-disable
                .csrf()
                .disable()
//- указываем, что Хэндлер для ошибок здесь - будет в др. классе в AuthEntryPointJwt
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPointJwt)
                //-отключение СЕССИИ
                //-STATELESS - Spring Security will never create an HttpSession
                // and it will never use it to obtain the SecurityContext
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // - добавление РАЗРЕШЕНИЙ
                .and()
                .authorizeRequests()
                //  - путь к контроллеру - "/auth/**" - по этому ЮРЛ - можно обращаться всем
                //- можно здесь задавать логику для каждого метода
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated();
        // - добавляем ФИЛЬТР класса - AuthTokenFilter
        http
                .addFilterBefore(authTokenFilter()
                        , UsernamePasswordAuthenticationFilter.class);
    }

    // - создание бина для будущего использования в др классах (для кодирования)
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //--VARIANT #1  ----in MEMMORY-------------
    //-создали нового ЮЗЕРА (где, как -пока неизвестно)
    //- UserDetails - инфа о Юзере (минимальная)
    //---------------------------------------------
//    @Bean
//    public UserDetailsService users() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{bcrypt}" +
//                        "$2a$12$FXTIEU/gh26GXmhvDpuPLew4fSI5kVK3sCdQIX52R3PfFvXqpoSCq")
//                .roles("USER")
////--password is:   100
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}" +
//                        "$2a$12$FXTIEU/gh26GXmhvDpuPLew4fSI5kVK3sCdQIX52R3PfFvXqpoSCq")
//                .roles("ADMIN", "USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
    //--------VARIANT #2 - save in DB ------------
    // jdbcAuthentification



}
