package by.step.test.dao.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
public class Human {

    public Human() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String surname;
    private Integer age;


}
