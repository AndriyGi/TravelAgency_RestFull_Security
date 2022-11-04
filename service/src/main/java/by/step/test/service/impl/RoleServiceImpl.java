package by.step.test.service.impl;

import by.step.test.dao.entity.Role;
import by.step.test.dao.repository.IRoleRepository;
import by.step.test.service.IRoleService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    public RoleServiceImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Role not found by name"));
        return role;
    }
}
