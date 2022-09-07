package by.step.test.dao.repository.impl;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.dao.repository.IVaucherRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VaucherRepositoryImpl implements IVaucherRepository {

    private List<Vaucher> vaucherList;
    private List<VaucherType> vaucherTypes;

    public VaucherRepositoryImpl(List<VaucherType> vaucherTypes) {
        this.vaucherTypes = vaucherTypes;
    }

    public VaucherRepositoryImpl() {
        vaucherList = new ArrayList<>();
    }


    @Override
    public List<Vaucher> findAllVauchers() {
        return vaucherList;
    }

    @Override
    public Vaucher saveNewVaucher(Vaucher vaucher) {
        boolean val = vaucherList.add(vaucher);
        if (val == true) {
            return vaucher;
        } else {
            return null;
        }
    }


    @Override
    public List<VaucherType> findAllVauchersByTupe() {
        return vaucherTypes;
    }

    @Override
    public VaucherType saveNewVaucherType(VaucherType vaucherType) {
        boolean val = vaucherTypes.add(vaucherType);
        if (val == true) {
            return vaucherType;
        } else {
            return null;
        }
    }
}




