package by.step.test.service;

import by.step.test.dao.entity.Human;
import by.step.test.dao.repository.AbstractHumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HumanService implements AbstractHumanService {

    @Autowired
    private AbstractHumanRepository humanRepository;


    @Override
    public String getHuman(){
        String s = humanRepository.getHumanList().stream()
                .findAny().get().toString();
        return s;
    }
    public Human getHumanObject(){
        Human human = humanRepository.getHumanList()
                .stream().findAny().get();
        return human;
    }

}
