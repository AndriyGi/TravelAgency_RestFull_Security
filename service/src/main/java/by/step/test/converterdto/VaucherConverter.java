package by.step.test.converterdto;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import org.springframework.stereotype.Component;

@Component
public class VaucherConverter {

    public Vaucher fromVaucherDtoToVaucher(VaucherDto vaucherDto){
        Vaucher vaucher = new Vaucher();
        vaucher.setId(vaucherDto.getId());
        vaucher.setDays(vaucher.getDays());
        vaucher.setPriceOneDay(vaucher.getPriceOneDay());
        vaucher.setVaucherFullPrice(vaucherDto.getVaucherFullPrice());
        return  vaucher;
    }

    public VaucherDto fromVaucherToVaucherDto(Vaucher vaucher){
        VaucherDto vaucherDto = new VaucherDto(vaucher.getId(), vaucher.getPriceOneDay()
                , vaucher.getDays(), vaucher.getVaucherFullPrice(), vaucher.getVaucherType());
        return vaucherDto;
    }
}
