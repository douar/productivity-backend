package douarmoua.productivitybackend.Repositories;

import douarmoua.productivitybackend.Entities.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, String> {
    Optional<Account> findAccountByUsernameAndPassword(String username, String password);
}
