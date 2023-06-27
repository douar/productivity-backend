package douarmoua.productivitybackend.Controllers;

import douarmoua.productivitybackend.Entities.Account;
import douarmoua.productivitybackend.Services.AccountService;
import douarmoua.productivitybackend._DTOs.NewAccountRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
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
}
