package org.example.services;

import org.example.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);
    void saveUser(User user);

    User findByUsername(String userName);


//    void changeUsername(String oldUsername, String password, String newUsername) throws NoSuchObjectException;
//User logIn(String username, String password);
//

}
