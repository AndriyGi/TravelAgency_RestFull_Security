package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.service.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;


@Service
public class HumanService implements IHumanService {



    @Autowired
    private IHumanRepository humanRepository;

    @Override
    public List<Human> findAll() {
        return humanRepository.findAll();
    }

    @Override
    public Human save(Human human) {
        return humanRepository.save(human);
    }

    @Override
    public void delete(Long id) {
        humanRepository.deleteById(id);
    }

    public List<Human> findAllByName(String name) {
        List<Human> allHumansByName = humanRepository.findAllByName(name);
        return allHumansByName;
    }

    @Override
    public List<Human> findAllBySurnameAndAge(String surname, Integer age) {
        return humanRepository.findAllBySurnameAndAge(surname, age);
    }
}