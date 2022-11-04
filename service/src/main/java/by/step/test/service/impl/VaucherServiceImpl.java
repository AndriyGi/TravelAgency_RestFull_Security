package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ExcVaucherNotFound;
import by.step.test.mapper.VaucherMapper;
import by.step.test.service.IVaucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Scope("prototype")
public class VaucherServiceImpl implements IVaucherService {

    @Autowired
    private IVaucherRepository vaucherRepository;
    @Autowired
    private IHumanRepository humanRepository;
    @Autowired
    private VaucherMapper vaucherMapper;


    public double calculatedVaucherPrice(Vaucher vaucher){
        double calculatedVaucherPrice = vaucher.getPriceOneDay() * vaucher.getDays();
        return calculatedVaucherPrice;
    }
    @Override
    public VaucherDto saveNewVaucher(Vaucher vaucher) {
        double calculatedVaucherPrice = vaucher.getPriceOneDay() * vaucher.getDays();
        vaucher.setVaucherFullPrice(calculatedVaucherPrice);
        Vaucher vaucherSaved = vaucherRepository.saveAndFlush(vaucher);
        return vaucherMapper.vaucherToVaucherDto(vaucherSaved);
    }

    @Override
    public void deleteById(Long id) {
        vaucherRepository.deleteById(id);

    }

    @Override
    public List<VaucherDto> findAllVauchers() {
        List<Vaucher> vaucherList = vaucherRepository.findAll();
        List<VaucherDto> vaucherDtoList = new ArrayList<>();
        for (Vaucher vaucher : vaucherList) {
            VaucherDto vaucherDto = vaucherMapper.vaucherToVaucherDto(vaucher);
            vaucherDtoList.add(vaucherDto);
        }
        return vaucherDtoList;
    }

    @Override
    public VaucherDto findById(Long id) throws ExcVaucherNotFound {
        Optional<Vaucher> vaucherOptional = vaucherRepository.findById(id);
        if (vaucherOptional.isPresent()) {
            VaucherDto vaucherDto = vaucherMapper.vaucherToVaucherDto(vaucherOptional.get());
            return vaucherDto;
        } else {
            throw new ExcVaucherNotFound("ВАУЧЕР по ID НЕ найден");
        }
    }

    public List<VaucherDto> findAllVauchersByHuman_Id(Long humanId) {
        Human human = humanRepository.findById(humanId).get();
        List<Vaucher> vaucherList = human.getVaucherList();
        List<VaucherDto> vaucherDtoList = vaucherList.stream().map(
                v -> vaucherMapper.vaucherToVaucherDto(v)).collect(Collectors.toList());
        return vaucherDtoList;
    }

    @Override
    public List<VaucherDto> attachVauchers_toHuman(Long humanId, Long vaucherId)
            throws ExcVaucherNotFound {
        Human human = humanRepository.findById(humanId)
                .orElseThrow(ExcVaucherNotFound::new);
        Vaucher vaucher = vaucherRepository.findById(vaucherId)
                .orElseThrow(ExcVaucherNotFound::new);

        List<Vaucher> vaucherList = human.getVaucherList();
        vaucherList.add(vaucher);
        human.setVaucherList(vaucherList);
        vaucherRepository.saveAndFlush(vaucher);

        List<VaucherDto> vaucherDtoList = vaucherList.stream().map(
                v -> vaucherMapper.vaucherToVaucherDto(v)).collect(Collectors.toList());
        return vaucherDtoList;
    }
}



