package by.step.test.dao.entity;

import lombok.*;
import javax.persistence.*;
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


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "vaucher_id")
//    private Vaucher vaucher;


    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "human_id")
    private List<Vaucher> vaucherList;

//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "human_vaucher", joinColumns = @JoinColumn(name = "human_id")
//            , inverseJoinColumns = @JoinColumn(name = "vaucher_id"))
//    private List<Vaucher> vaucherList = new ArrayList<>();

}
