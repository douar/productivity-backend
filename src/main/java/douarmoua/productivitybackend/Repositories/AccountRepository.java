package douarmoua.productivitybackend.Repositories;

import douarmoua.productivitybackend.Entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
