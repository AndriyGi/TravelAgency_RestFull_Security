package by.step.test.dao.repository;

import by.step.test.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {

     Role findByName(String name);
}
