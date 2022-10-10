package by.step.test.service.impl;

import by.step.test.converterdto.HumanConverter;
import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.HumanDto;
//import by.step.test.exception.EntityNotFoundException;
import by.step.test.exception.ExcEmptyHumansList;
import by.step.test.exception.ExcHumanIsPresent;
import by.step.test.exception.ExcVaucherNotFound;
import by.step.test.exception.ExcHumanNotFound;
import by.step.test.mapper.HumanMapper;
import by.step.test.mapper.VaucherMapper;
import by.step.test.service.IHumanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HumanServiceImpl implements IHumanService {
    @Autowired
    private HumanConverter humanConverter;
    @Autowired
    private IHumanRepository humanRepository;
    @Autowired
    private IVaucherRepository vaucherRepository;
    @Autowired
    private HumanMapper humanMapper;
    @Autowired
    private VaucherMapper vaucherMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private Object Comparator;
    private Object Human;
    private Object List;



    @Override
    public boolean existByEmail(String mail) {
       Optional<Human> human = humanRepository.findByMail(mail);
        return human.isPresent();
    }

    @Override
    public HumanDto save(Human human) throws ExcHumanIsPresent {
        human.setPass(bCryptPasswordEncoder.encode(human.getPass()) );
        log.info("SERVICE -- exstracting ALL HUMANs LIST  from REPOSITORY ");
        List<Human> humanList = humanRepository.findAll();
//        log.info(" checking FOR EMPTY LIST ");
//        if (humanList.isEmpty()) {
//            log.info(" IF Its empty list - THROW EXC-on  ");
//            throw new ExcEmptyHumansList("Its empty list");
//        }
        log.info(" SERVICE - Проверка на наличие такого Хуман в БД ");
        boolean result = humanList.stream()
                .anyMatch(human1 ->
                        human1.getName().equals(human.getName())
                                &&
                                human1.getSurname().equals(human.getSurname()));
        log.info("SERVICE -- if RESULT ");
        if (result) {
            throw new ExcHumanIsPresent(" Human IS- HEAR - in OUR DB  !!!");
        }
        log.info("SERVICE -- HUMANDTO MAPPING ------");
        HumanDto humanDto = humanMapper.humanToHumanDto(humanRepository.save(human));
        log.info(" SERVICE  -  new  Human was SAVED in DB !!!");
        return humanDto;
    }

    @Override
    public HumanDto findById(Long id) throws ExcHumanNotFound {
        log.info("TRY to find Human(OPTIONAL");
        Optional<Human> humanOpt = humanRepository.findById(id);
        log.info("CHECKING if Human is present ??  ");
        if (humanOpt.isPresent()) {
            log.info("HUMAN FOUNDED !! - returning -humanDto - see !! ");
            return humanMapper.humanToHumanDto(humanOpt.get());
        } else {
            ExcHumanNotFound excHumanNotFound = new ExcHumanNotFound();
            log.error(excHumanNotFound.getMessage("HUMAN NOT FOUND by ID !!!")
                    , excHumanNotFound);
            throw new ExcHumanNotFound("Human not foud by id");
        }
    }

    @Override
    public Long delete(Long id) {
        humanRepository.deleteById(id);
        return id;
    }

    @Override
    public List<HumanDto> findAll() throws ExcEmptyHumansList {
        List<HumanDto> humanDtoList = new ArrayList<>();
        List<Human> humanListAll = humanRepository.findAll();
        try {
            log.info("TRY to find ALL Humans");
            humanListAll = humanRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        for (Human human1 : humanListAll) {
            HumanDto humanDto = humanMapper.humanToHumanDto(human1);
            humanDtoList.add(humanDto);
        }
        log.info("All Humans retrieved !! ");
        return humanDtoList;
    }

    @Override
    public List<HumanDto> findAllHumansByVaucher_Id(Long vaucherId) throws ExcVaucherNotFound {
        Optional<Vaucher> vaucherOptional = vaucherRepository.findById(vaucherId);
        if (vaucherOptional.isPresent()) {
            Vaucher vaucher = vaucherOptional.get();
            List<Human> humanList = vaucher.getHumanList();
            List<HumanDto> humanDtoList = humanList.stream().map(
                    human -> humanMapper.humanToHumanDto(human)).collect(Collectors.toList());
            return humanDtoList;
        } else {
            throw new ExcVaucherNotFound("Vaucher not found by ID");
        }
    }

}

//    @Override
//    public HumanDto findHumanByVaucherId(Long id) {
//        Vaucher vaucher = vaucherRepository.findById(id)
//                .orElseThrow(EntityNotFoundException::new);
//        return humanMapper.humanToHumanDto(vaucher.getHuman());
//    }


//    @Override
//    public HumanDto attachVauchers_toHuman(Long humanId, Long vaucherId) {
//        Human human = humanRepository.attachVauchers_toHuman(humanId, vaucherId);
//        HumanDto humanDto = humanConverter.fromHumanToHumanDto(human);
//        return humanDto;
//    }

//    @Override
//    public Human attachVaucherToHuman(Long humanId, Long vaucherId) {
//        Human human = humanRepository.findById(humanId)
//                .orElseThrow(EntityNotFoundException::new);
//        Vaucher vaucher = vaucherRepository.findById(vaucherId)
//                .orElseThrow(EntityNotFoundException::new);
//        human.setVaucher(vaucher);
//        return human;
//    }


//    public List<Human> findAllByName(String name) {
//        List<Human> allHumansByName = humanRepository.findAllByName(name);
//        return allHumansByName;
//    }

//    @Override
//    public List<Human> findAllBySurnameAndAge(String surname, Integer age) {
//        return humanRepository.findAllBySurnameAndAge(surname, age);
//    }

