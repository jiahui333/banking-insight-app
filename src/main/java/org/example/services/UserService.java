package org.example.services;

import org.example.models.User;

public interface UserService {

    void createUser(String firstName, String secondName, String username, String password);

    void changeUsername(String oldUsername, String password, String newUsername);

    User readUser(String username, String password);

}
