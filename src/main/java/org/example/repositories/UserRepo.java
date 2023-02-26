package org.example.repositories;

import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.NoSuchObjectException;
import java.util.NoSuchElementException;

public interface UserRepo extends JpaRepository<User, Long> {
//    User findUserByLogIn(String username, String password) throws NoSuchElementException;

}
