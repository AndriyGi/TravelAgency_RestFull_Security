package by.step.test.dao.repository.impl;


import by.step.test.dao.entity.Human;
import by.step.test.dao.repository.IHumanRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HumanRepositoryImpl implements IHumanRepository {

    private List<Human> humanList;

    public HumanRepositoryImpl() {
        this.humanList = new ArrayList<>();
        humanList.add(new Human("IVAN", "Petron"));
    }




    @Override
    public List<Human> findAll() {
        return humanList;
    }

    @Override
    public Human save(Human human) {
        humanList.add(human);
        return  human;
    }

    @Override
    public Human delete(Human human) {
        boolean val = humanList.remove(human);
        if(val=true){
            return human;
        }
        return null;
    }
}
