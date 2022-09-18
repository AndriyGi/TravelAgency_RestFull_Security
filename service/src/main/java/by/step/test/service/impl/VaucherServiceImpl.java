package by.step.test.service.impl;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.exception.ServiceException;
import by.step.test.service.IVaucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Scope("prototype")
public class VaucherServiceImpl implements IVaucherService {

    @Autowired
    private IVaucherRepository vaucherRepository;
    private Vaucher vaucher;

    @Override
    public List<Vaucher> findAllVauchers() {
        return vaucherRepository.findAll();
    }

    @Override
    public Vaucher findById(Long id) throws ServiceException {
        Optional<Vaucher> vaucherOptional = vaucherRepository.findById(id);
        if (vaucherOptional.isPresent()) {
            return vaucherOptional.get();
        } else {
//            System.out.println("объект по ID не найден");
            throw new ServiceException("объект по ID не найден");
        }
    }
    @Override
    public Vaucher saveNewVaucher(Vaucher vaucher) {
        double calculatedVaucherPrice = vaucher.getPriceOneDay() * vaucher.getDays();
        vaucher.setVaucherFullPrice(calculatedVaucherPrice);
        Vaucher vaucherSaved = vaucherRepository.saveAndFlush(vaucher);
        return vaucherSaved;
    }
    @Override
    public Vaucher deleteVaucher(Vaucher vaucher) {
        vaucherRepository.delete(vaucher);
        return vaucher;
    }
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

}
