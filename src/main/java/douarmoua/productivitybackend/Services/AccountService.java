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
    public Account createAccount(NewAccountRequestDTO requestDTO) {
        try {
            return this.accountRepository.save(
                    new Account(requestDTO.email, requestDTO.firstName, requestDTO.lastName, requestDTO.username, requestDTO.password)
            );
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    // -- GET/LOGIN ACCOUNT -- //
    public Account loginAccount(String username, String password) {
        Optional<Account> accountOptional = this.accountRepository.findAccountByUsernameAndPassword(username, password);
        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return accountOptional.get();
    }

    // -- DELETE ACCOUNT -- //
    public void deleteAccount(String accountId) {
        Optional<Account> accountOptional = this.accountRepository.findById(accountId);
        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.accountRepository.deleteById(accountId);
        }
    }

    // -- UPDATE ACCOUNT -- //
    public void updateAccount(NewAccountRequestDTO requestDTO, String accountId){
        Optional<Account> accountOptional = this.accountRepository.findById(accountId);
        if(accountOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            Account account = accountOptional.get();

            if(requestDTO.firstName != null){
                account.setFirstName(requestDTO.firstName);
            }

            if(requestDTO.lastName != null){
                account.setLastName(requestDTO.lastName);
            }

            if(requestDTO.username != null){
                account.setUsername(requestDTO.username);
            }

            if(requestDTO.password != null){
                account.setPassword(requestDTO.password);
            }

            if(requestDTO.email != null){
                account.setEmail(requestDTO.email);
            }

            this.accountRepository.save(account);
        }
    }

}
