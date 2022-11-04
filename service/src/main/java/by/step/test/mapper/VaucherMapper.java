package by.step.test.mapper;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface VaucherMapper {

    Vaucher vaucherDtoToVaucher(VaucherDto vaucherDto);
    VaucherDto vaucherToVaucherDto(Vaucher vaucher);

}
