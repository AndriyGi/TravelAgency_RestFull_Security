package by.step.test.dao.entity.security;


import by.step.test.dao.entity.Vaucher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private List<Vaucher> vaucherList;
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String mail;
    private String pass;
    private List<String> roleList;


}
