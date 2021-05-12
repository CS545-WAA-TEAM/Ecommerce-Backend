package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
