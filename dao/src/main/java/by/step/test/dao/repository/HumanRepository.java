package by.step.test.dao.repository;


import by.step.test.dao.entity.Human;
import java.util.ArrayList;
import java.util.List;

public class HumanRepository implements AbstractHumanRepository {

    private List<Human> humanList;

    public HumanRepository() {
        this.humanList = new ArrayList<>();
        humanList.add(new Human("Vasia","Pupkin"));
    }

    public List<Human> getHumanList() {
        return humanList;
    }
}
