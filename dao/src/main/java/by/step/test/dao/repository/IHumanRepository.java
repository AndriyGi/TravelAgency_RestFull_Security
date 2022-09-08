package by.step.test.dao.repository;

import by.step.test.dao.entity.Human;

import java.util.List;

public interface IHumanRepository {

    List<Human> findAll();
    Human save(Human human);
    Human delete(Human human);
}
