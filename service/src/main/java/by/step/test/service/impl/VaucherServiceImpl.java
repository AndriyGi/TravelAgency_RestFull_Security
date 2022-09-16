package by.step.test.service.impl;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.exception.ServiceException;
import by.step.test.service.IVaucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class VaucherServiceImpl implements IVaucherService {

    @Autowired
    private IVaucherRepository vaucherRepository;
    private Vaucher vaucher;

    @Override
    public List<Vaucher> findAllVauchers() {
        return vaucherRepository.findAll();
        // to do - add vauchers
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
        return vaucherRepository
                .saveAndFlush(vaucher);
    }

    @Override
    public Vaucher deleteVaucher(Vaucher vaucher) {
        vaucherRepository.delete(vaucher);
        return vaucher;
    }

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
//
//    @Override
//    public VaucherType saveNewVaucherType(VaucherType vaucherType) {
//        return vaucherRepository.saveNewVaucherType(vaucherType);
//    }
//

    @Override
    public Vaucher buildVaucher(VaucherType type, int price, int days) {
        Vaucher vaucherResult = vaucherRepository.findAll().stream()
                .filter(vaucherType -> vaucherType.getVaucherType().equals(type))
                .filter(vaucherPrice -> vaucherPrice.getPriceOneDay() == price)
                .filter(vaucherDays -> vaucherDays.getDays() == days)
                .findAny().orElseThrow(RuntimeException::new);
//        double calculatedVaucherPrice = calculateVaucherPrice(vaucherResult);

        return vaucherResult;
    }

    public double calculateVaucherPrice(Vaucher vaucher) {
        return vaucher.getPriceOneDay() * vaucher.getDays();

    }


    @Override
    public void vaucherSortPrice() {
        vaucherRepository.findAll().sort(Comparator.comparing(Vaucher::getPriceOneDay));
    }

    @Override
    public void vaucherSortDays() {
        vaucherRepository.findAll().sort(Comparator.comparing(Vaucher::getDays));
    }

    @Override
    public void vaucherSortType() {
        vaucherRepository.findAll().sort(Comparator.comparing(Vaucher::getVaucherType));
    }


}
