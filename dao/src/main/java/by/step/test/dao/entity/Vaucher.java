package by.step.test.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
@Getter
@Setter
public class Vaucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vaucher_type")
    @Enumerated(EnumType.STRING)
    private VaucherType vaucherType;

    private Double priceOneDay;
    private Integer days;
    private Double vaucherFullPrice;

  //=================================================
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "human_id")
    private Human human;

////-----------------------------------------------
//    @OneToMany(mappedBy = "vaucher", cascade = CascadeType.REFRESH)
//    private List<Human> humanList;

//_________________________________________

//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "vaucher_id")
//    private List<Human> humanList;


//        @JoinColumn
//    @OneToOne(cascade =  CascadeType.ALL)
//    private  Human human;
//

}
