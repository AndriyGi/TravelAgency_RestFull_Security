package by.step.test.dao.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Human {

    public Human() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Integer age;

//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "human_vaucher", joinColumns = @JoinColumn(name = "human_id")
//            , inverseJoinColumns = @JoinColumn(name = "vaucher_id"))
//    private List<Vaucher> vaucherList = new ArrayList<>();


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "vaucher_id")
//    private Vaucher vaucher;



    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vaucher_list_id")
    private List<Vaucher> vaucherList;

}
