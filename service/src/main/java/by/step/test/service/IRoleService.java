package by.step.test.service;

import by.step.test.dao.entity.Role;

public interface IRoleService {

    Role findByName(String name);
}
