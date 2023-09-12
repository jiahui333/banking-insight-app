package org.example.repositories;
import org.example.models.Account;
import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findAllByUser(User user);
    @Query("SELECT MAX(a.id) FROM Account a")
    Long findMaxAccountId();
}
