package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.EntityNotFoundException;
import by.step.test.exception.ServiceException;
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

//       Vaucher vaucherToDelete = vaucherRepository.findById(id).get();
//       VaucherDto vaucherDto = vaucherMapper.vaucherToVaucherDto
//               (vaucherRepository.(id));

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
    public VaucherDto findById(Long id) throws ServiceException {
        Optional<Vaucher> vaucherOptional = vaucherRepository.findById(id);
        if (vaucherOptional.isPresent()) {
            VaucherDto vaucherDto = vaucherMapper.vaucherToVaucherDto(vaucherOptional.get());
            return vaucherDto;
        } else {
            throw new ServiceException("объект по ID не найден");
        }
    }

    public List<VaucherDto> findAllVauchersByHuman_Id(Long humanId) {
        Human human = humanRepository.findById(humanId).get();
        List<Vaucher> vaucherList = human.getVaucherList();
        List<VaucherDto> vaucherDtoList = vaucherList.stream().map(
                v -> vaucherMapper.vaucherToVaucherDto(v)).collect(Collectors.toList());
        return vaucherDtoList;
    }

//    public static void main(String[] args)  {
//        Human human = null;
////        Human human = new Human();
//        Optional<Human> humanOptional = Optional.ofNullable(human);
//        try {
//            run(humanOptional);
//            System.out.println("ttt");
//        } catch (RuntimeException customEntityNotFoundExc) {
//            customEntityNotFoundExc.printStackTrace();
//        }
//    }
//
//    private static void run(Optional<Human> humanOptional)  {
//        if(humanOptional.isEmpty()){
//            throw new EntityNotFoundException("message");
//        }
//    }

    @Override
    public List<VaucherDto> attachVauchers_toHuman(Long humanId, Long vaucherId) {
        Human human = humanRepository.findById(humanId)
                .orElseThrow(EntityNotFoundException::new);
        Vaucher vaucher = vaucherRepository.findById(vaucherId)
                .orElseThrow(EntityNotFoundException::new);

        List<Vaucher> vaucherList = human.getVaucherList();
        vaucherList.add(vaucher);
        human.setVaucherList(vaucherList);
        vaucherRepository.saveAndFlush(vaucher);

        List<VaucherDto> vaucherDtoList = vaucherList.stream().map(
                v -> vaucherMapper.vaucherToVaucherDto(v)).collect(Collectors.toList());
        return vaucherDtoList;
    }
}

//    TODO      ПРИСВОЕНИЕ  через метод СКЛ запроса - в репозитории ваучера
//    @Override
//    public Integer attachVauchers_toHuman(Long humanId, Long vaucherId) {
//        return vaucherRepository.attachVaucherss_toHuman(humanId, vaucherId);
//    }


//    public void save(Zoo zoo) {
//        //TODO смотреть сюда для связи one-to-many
//        zoo.getAnimalList().forEach(animal -> animal.setZoo(zoo));
//        zooRepository.save(zoo);
//    }


//    @Override
//    public List<Vaucher> findVauchersByParam(VaucherType type, Double fromPrice, Double toPrice
//            , Integer fromDays, Integer toDays) {
//        List<Vaucher> vaucherList = vaucherRepository.findAll();
//        List<Vaucher> resultListParam = vaucherList.stream().filter(vaucher -> {
//            boolean resultDates = vaucher.getDays() >= fromDays && vaucher.getDays() <= toDays;
//            boolean resultPrice = vaucher.getPriceOneDay() >= fromPrice && vaucher.getPriceOneDay() <= toPrice;
//            boolean resultType = vaucher.getVaucherType().equals(type);
//            return resultDates && resultPrice && resultType;
//        }).collect(Collectors.toList());
//        return resultListParam;
//    }

//    @Override
//    public void vaucherSortPrice() {
//        vaucherRepository.findAll().sort(Comparator.comparing(Vaucher::getPriceOneDay));
//    }
//
//    @Override
//    public void vaucherSortDays() {
//        vaucherRepository.findAll().sort(Comparator.comparing(Vaucher::getDays));
//    }
//
//    @Override
//    public void vaucherSortType() {
//        vaucherRepository.findAll().sort(Comparator.comparing(Vaucher::getVaucherType));
//    }
//


//
//    @Override
//    public Object findAllByVaucherType(VaucherType vaucherType) throws ServiceException {
//        Optional<VaucherType> vaucherOptional = vaucherRepository.findAllByVaucherType(vaucherType);
//        if (vaucherOptional.isPresent()) {
//            return vaucherOptional.get();
//        } else {
//            throw new ServiceException("объект по ID не найден");
//        }
//    }

//    @Override
//    public Vaucher buildVaucher(VaucherType type, Double price, Integer days) {
//        Vaucher vaucherResult = vaucherRepository.findAll().stream()
//                .filter(vaucherType -> vaucherType.getVaucherType().equals(type))
//                .filter(vaucherPrice -> vaucherPrice.getPriceOneDay().equals(price))
//                .filter(vaucherDays -> vaucherDays.getDays().equals(days))
//                .findAny().orElseThrow(RuntimeException::new);
//        return null;
//    }


