package by.step.test.converterdto;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import org.springframework.stereotype.Component;

@Component
public class HumanConverter {

   public Human fromHumanDtoToHuman(HumanDto humanDto){
       Human human = new Human();
       human.setName(humanDto.getName());
       human.setSurname(humanDto.getSurname());
       return  human;
   }

   public HumanDto fromHumanToHumanDto(Human human){
       HumanDto humanDto = new HumanDto(human.getId(), human.getName()
               , human.getSurname(), human.getAge());
       return  humanDto;
   }


}
