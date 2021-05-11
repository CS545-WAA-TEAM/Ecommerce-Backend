package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Iterable<User> getAllUsers();

    User getUserById(long id);

    User addUser(User user);

    void deleteUser(long id);

}
