package by.step.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HumanDto {


    private Long id;
    private String name;
    private String surname;
    private Integer age;


}
