package by.step.test.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vaucher")
@Entity
@Getter
@Setter
public class Vaucher {

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "link_human_vaucher",
            joinColumns = @JoinColumn(name = "vaucher_id"),
            inverseJoinColumns = @JoinColumn(name = "human_id"),
            foreignKey = @ForeignKey(name = "fk_vaucher_to_human")
    )
    private List<Human> humanList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vaucher_type")
    @Enumerated(EnumType.STRING)
    private VaucherType vaucherType;
    @Basic
    @Column(name = "priceoneday")
    private Double priceOneDay;
    @Basic
    @Column(name = "days")
    private Integer days;
    @Basic
    @Column(name = "vfullprice")
    private Double vaucherFullPrice;

    @ManyToMany(mappedBy = "vaucherList")
    private List<Human> human = new ArrayList<>();

}
