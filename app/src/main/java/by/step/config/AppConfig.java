package by.step.config;

import by.step.test.dao.repository.AbstractHumanRepository;
import by.step.test.dao.repository.HumanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    AbstractHumanRepository humanRepository (){
        return new HumanRepository();
    }
}
