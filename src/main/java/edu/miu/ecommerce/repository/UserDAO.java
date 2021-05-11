package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
}
