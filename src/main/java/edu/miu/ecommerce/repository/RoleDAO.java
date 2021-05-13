package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDAO extends CrudRepository<Role, Long> {
}
