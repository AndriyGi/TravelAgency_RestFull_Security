package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.HumanDto;
import by.step.test.exception.ExcEmptyHumansList;
import by.step.test.exception.ExcHumanIsPresent;
import by.step.test.exception.ExcHumanNotFound;
import by.step.test.exception.ExcVaucherNotFound;
import by.step.test.mapper.HumanMapper;
import by.step.test.service.IHumanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import by.step.test.exception.EntityNotFoundException;

@Service
@Slf4j
public class HumanServiceImpl implements IHumanService {
    @Autowired
    private IHumanRepository humanRepository;
    @Autowired
    private IVaucherRepository vaucherRepository;
    @Autowired
    private HumanMapper humanMapper;
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
        log.info("SERVICE -- HUMAND  TO MAPPING ------");
        HumanDto humanDto = humanMapper.humanToHumanDto(humanRepository.save(human));
        log.info(" SERVICE  -  new  Human was SAVED in DB !!!");
        return humanDto;
    }

    @Override
    public HumanDto findById(Long id) throws ExcHumanNotFound {
        log.info("TRY to find Human('OPTIONAL");
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


