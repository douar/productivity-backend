package douarmoua.productivitybackend.Controllers;

import douarmoua.productivitybackend.Entities.BudgetCategory;
import douarmoua.productivitybackend.Services.BudgetService;
import douarmoua.productivitybackend._DTOs.NewBudgetCategoryRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prodcutivity/budget")
@CrossOrigin
public class BudgetController {

    BudgetService budgetService;

    public BudgetController (BudgetService budgetService){
        this.budgetService = budgetService;
    }

    @PostMapping("/newCategory")
    public BudgetCategory newBudgetCategory(@RequestBody NewBudgetCategoryRequestDTO requestDTO){
        return this.budgetService.newBudgetCategory(requestDTO);
    }

}
