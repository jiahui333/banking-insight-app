package org.example.services;

import org.example.repositories.InMemoryAccountHolderRepo;

public interface AccountHolderService {

    void createAccountHolder(String firstName, String secondName, String email);
}
