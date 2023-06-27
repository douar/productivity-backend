package douarmoua.productivitybackend.Services;

import douarmoua.productivitybackend.Entities.Account;
import douarmoua.productivitybackend.Repositories.AccountRepository;
import douarmoua.productivitybackend._DTOs.NewAccountRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // -- CREATE NEW ACCOUNT -- //
    public Account createAccount(NewAccountRequestDTO requestDTO){
        try {
            return this.accountRepository.save(
                    new Account(requestDTO.email, requestDTO.firstName, requestDTO.lastName, requestDTO.username, requestDTO.password)
            );
        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    // -- GET/LOGIN ACCOUNT -- //
    public Account getAccount(String username, String password){
        Optional<Account> accountOptional = this.accountRepository.findAccountByUsernameAndPassword(username, password);
        if (accountOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return accountOptional.get();
    }
}
