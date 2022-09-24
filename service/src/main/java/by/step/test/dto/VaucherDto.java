package by.step.test.dto;

import by.step.test.dao.entity.VaucherType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;



@NoArgsConstructor
@Getter
@Setter
@Component
public class VaucherDto {

        private Long id;

        private Double priceOneDay;
        private Integer days;
        private Double vaucherFullPrice;
        private VaucherType vaucherType;

        public VaucherDto(Long id, Double priceOneDay, Integer days, Double vaucherFullPrice, VaucherType vaucherType) {
                this.id = id;
                this.priceOneDay = priceOneDay;
                this.days = days;
                this.vaucherFullPrice = vaucherFullPrice;
                this.vaucherType = vaucherType;
        }

        //
//        public VaucherDto(Long id, Double priceOneDay, Integer days
//                , Double vaucherFullPrice) {
//        }
}
