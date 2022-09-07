package by.step.test.service.impl;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dao.repository.impl.VaucherRepositoryImpl;
import by.step.test.service.IVaucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaucherServiceImpl implements IVaucherService {


    @Autowired
    private IVaucherRepository vaucherRepository;


    @Override
    public List<Vaucher> findAllVauchers() {
        return findAllVauchers();
    }


    @Override
    public Vaucher saveNewVaucher(Vaucher vaucher) {
        return vaucherRepository.saveNewVaucher(vaucher);
    }

    @Override
    public List<VaucherType> findAllVaucherTypes() {
        return findAllVaucherTypes();
    }

    @Override
    public VaucherType saveNewVaucherType(VaucherType vaucherType) {
        return vaucherRepository.saveNewVaucherType(vaucherType);
    }
}
