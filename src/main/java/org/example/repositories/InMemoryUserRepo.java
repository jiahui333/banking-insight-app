package org.example.repositories;

import org.example.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Repository
public class InMemoryUserRepo implements UserRepo {
    private List<User> users = new ArrayList<>();
    @Override
    public void storeUser(User user) {
        users.add(user);
    }

    @Override
    public User getUser(String username, String password) throws NoSuchElementException {
        for (User user : users) {
            System.out.println("repo" + user.getUsername());
            System.out.println(user.getPassword());
            if (Objects.equals(user.getUsername(), username) && Objects.equals(user.getPassword(), password)) {
                return user;
            }
        }
        throw new NoSuchElementException("Cannot find the account holder");
    }
}
