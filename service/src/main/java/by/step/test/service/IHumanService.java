package by.step.test.service;

import by.step.test.dao.entity.Human;

import java.util.List;

public interface IHumanService {

    List<Human> findAll();
    Human save(Human human);



}
