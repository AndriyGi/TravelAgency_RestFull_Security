package by.step.test.service.impl;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.service.IVaucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaucherServiceImpl implements IVaucherService {


    @Autowired
    private IVaucherRepository vaucherRepository;

//
//    @Override
//    public List<Vaucher> findAllVauchers() {
//        return findAllVauchers();
//    }


    @Override
    public List<Vaucher> findAllVauchers() {
        return vaucherRepository.findAllVauchers();
    }

    @Override
    public Vaucher saveNewVaucher(Vaucher vaucher) {
        return vaucherRepository.saveNewVaucher(vaucher);
    }

//    @Override
//    public Vaucher getAllVauchers(List<Vaucher> vaucher) {
//        return vaucherRepository.findAllVauchers();
//    }

//    @Override
//    public Vaucher getAllVauchers(Vaucher vaucher) {
//        return vaucherRepository.findAllVauchers();
//    }

    @Override
    public List<VaucherType> findAllVaucherTypes() {
        return vaucherRepository.findAllVauchersByTupe();
    }

    @Override
    public VaucherType saveNewVaucherType(VaucherType vaucherType) {
        return vaucherRepository.saveNewVaucherType(vaucherType);
    }

    @Override
    public Vaucher findVaucher(VaucherType type, int price, int days) {
        Vaucher vaucherResult = vaucherRepository.findAllVauchers().stream()
                .filter(vaucherType -> vaucherType.getVaucherType().equals(type))
                .filter(vaucherPrice -> vaucherPrice.getPrice() == price)
                .filter(vaucherDays -> vaucherDays.getDays() == days)
                .findAny().orElseThrow(RuntimeException::new);
        return vaucherResult;
    }

    @Override
    public void vaucherSortPrice() {
        vaucherRepository.findAllVauchers().sort(Comparator.comparing(Vaucher::getPrice));
    }
}
