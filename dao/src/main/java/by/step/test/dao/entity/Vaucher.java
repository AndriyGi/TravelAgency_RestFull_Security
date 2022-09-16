package by.step.test.dao.entity;

import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
@Getter
@Setter

public class Vaucher {

//    @Enumerated(EnumType.ORDINAL)
//    private VaucherType status;

//    @JoinColumn
//    @OneToOne(cascade =  CascadeType.ALL)
//    private  Human human;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vaucher_type")
    @Enumerated(EnumType.STRING)
    private VaucherType vaucherType;

    private Double priceOneDay;
    private Integer days;

//    private Double priceFull;





}
