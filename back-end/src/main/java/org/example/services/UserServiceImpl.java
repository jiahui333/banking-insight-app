package org.example.services;

import org.example.models.User;
import org.example.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

//    @Override
//    public User logIn(String username, String password) throws NoSuchElementException {
//        return userRepo.findUserByLogIn(username, password);
//    }
//
//    @Override
//    public void changeUsername(String oldUsername, String password, String newUsername) throws NoSuchElementException {
//        User user = userRepo.getUser(oldUsername, password);
//        user.setUsername(newUsername);
//    }

}
