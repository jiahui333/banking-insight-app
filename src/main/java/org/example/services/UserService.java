package org.example.services;

import org.example.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);
    void saveUser(User user);


//    void changeUsername(String oldUsername, String password, String newUsername) throws NoSuchObjectException;
//User logIn(String username, String password);
//

}
