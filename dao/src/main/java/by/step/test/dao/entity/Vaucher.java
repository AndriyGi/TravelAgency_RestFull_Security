package by.step.test.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vaucher {

    private VaucherType vaucherType;
    private int price;
    private int days;

    // TODO:  add any fields;


}
