package by.step.test.mapper;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE
        , componentModel = "spring")
public interface HumanMapper {

    Human humanDtoToHuman(HumanDto humanDto);
    HumanDto humanToHumanDto(Human human);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Human updateHumanFromHumanDto(HumanDto humanDto, @MappingTarget Human human);

}








//        @AfterMapping
//        default void linkChildrens(@MappingTarget Human human) {
//            human.getChildrens().forEach(children -> children.setHuman(human));
//        }



