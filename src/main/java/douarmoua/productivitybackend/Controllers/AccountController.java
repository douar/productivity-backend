package douarmoua.productivitybackend.Controllers;

import douarmoua.productivitybackend.Entities.Account;
import douarmoua.productivitybackend.Services.AccountService;
import douarmoua.productivitybackend._DTOs.NewAccountRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productivity/account")
@CrossOrigin
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public Account createAccount(@RequestBody NewAccountRequestDTO requestDTO){
        return this.accountService.createAccount(requestDTO);
    }

    @GetMapping
    public Account loginAccount(@RequestParam String username, @RequestParam String password){
        return this.accountService.loginAccount(username, password);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam String accountId){
        this.accountService.deleteAccount(accountId);
    }

    @PutMapping
    public void updateAccount(@RequestBody NewAccountRequestDTO requestDTO, @RequestParam String accountId){
        this.accountService.updateAccount(requestDTO, accountId);
    }

}
