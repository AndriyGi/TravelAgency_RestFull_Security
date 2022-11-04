package by.step.test.dao.entity;

import lombok.*;
import javax.persistence.*;

import java.util.List;

@Table(name = "human",uniqueConstraints
 = {@UniqueConstraint(columnNames = {"name","surname"})})
//@Table(name = "human")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Human {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "link_human_vaucher",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "vaucher_id"),
            foreignKey = @ForeignKey(name = "fk_human_to_vaucher")
    )
    private List<Vaucher> vaucherList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "human_role",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            foreignKey = @ForeignKey(name = "fk_human_to_role")
    )
    private List<Role> roleList;

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

    private String mail;
    private String pass;

}
