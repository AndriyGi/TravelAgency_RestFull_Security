package by.step.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Getter
@Setter
@Component
public class HumanDto {

    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public HumanDto(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
