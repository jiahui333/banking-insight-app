package org.example.repositories;

import org.example.models.User;

public interface UserRepo {
    //create a new account holder
    void storeUser(User user);
    //read an account holder
    User getUser(String username, String password);
}
