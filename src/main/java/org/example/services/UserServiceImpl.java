package org.example.services;

import org.example.models.User;
import org.example.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void createUser(String firstName, String secondName, String userName, String password) {
        User user = new User(firstName, secondName, userName, password);
        userRepo.storeUser(user);
    }

    @Override
    public void changeUsername(String oldUsername, String password, String newUsername) {
        User user = userRepo.getUser(oldUsername, password);
        user.setUsername(newUsername);
    }

    @Override
    public User readUser(String username, String password) {
        return userRepo.getUser(username, password);
    }

}
