package by.step.test.dao.repository;

import by.step.test.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {

     Optional<Role> findByName(String name);

}
