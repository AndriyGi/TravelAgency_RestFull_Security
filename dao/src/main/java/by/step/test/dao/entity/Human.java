package by.step.test.dao.entity;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "human")
@Entity
@Getter
@Setter
public class Human {

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "link_human_vaucher",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "vaucher_id"),
            foreignKey = @ForeignKey(name = "fk_human_to_vaucher")
    )
    private List<Vaucher> vaucherList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "age")
    private Integer age;



//    @JoinTable(
//            name = "link_driver_car",
//            joinColumns = @JoinColumn(name = "car_id"),
//            inverseJoinColumns = @JoinColumn(name = "driver_id"),
//            foreignKey = @ForeignKey(name = "fk_car_to_driver")
//    )

    //===============================
//    @OneToMany(mappedBy = "human", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private List<Vaucher> vaucherList;

//-------------------------------
//    @ManyToOne
//    private Vaucher vaucher;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "vaucher_id")
//    private Vaucher vaucher;




}
