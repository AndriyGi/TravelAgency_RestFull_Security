package by.step.test.dao.repository.impl;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.dao.repository.IVaucherRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@NoArgsConstructor
@Repository
public class VaucherRepositoryImpl implements IVaucherRepository {


    private List<Vaucher> vaucherList;
    private List<VaucherType> vaucherTypesList;
    private Vaucher vaucher;

    public VaucherRepositoryImpl(Vaucher vaucher) {
        this.vaucher = vaucher;
    }

    public VaucherRepositoryImpl(List<Vaucher> vaucherList, List<VaucherType> vaucherTypesList, Vaucher vaucher) {
        this.vaucherList = vaucherList;
        this.vaucherTypesList = vaucherTypesList;
        this.vaucher = vaucher;
        vaucherList.add(new Vaucher("SPORT", 1200, 21));
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
        return vaucherTypesList;
    }

    @Override
    public VaucherType saveNewVaucherType(VaucherType vaucherType) {
        boolean val = vaucherTypesList.add(vaucherType);
        if (val == true) {
            return vaucherType;
        } else {
            return null;
        }
    }
}




