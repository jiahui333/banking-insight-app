package org.example.repositories;
import org.example.models.Account;
import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findByUser(User user);
}
