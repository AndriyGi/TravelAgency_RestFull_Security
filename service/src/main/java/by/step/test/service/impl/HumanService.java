package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.service.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Human delite(Human human) {
        return humanRepository.delete(human);
    }
}
