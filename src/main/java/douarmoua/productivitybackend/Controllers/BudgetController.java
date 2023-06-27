package douarmoua.productivitybackend.Controllers;

import douarmoua.productivitybackend.Entities.BudgetCategory;
import douarmoua.productivitybackend.Services.BudgetService;
import douarmoua.productivitybackend._DTOs.NewBudgetCategoryRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productivity/budget")
@CrossOrigin
public class BudgetController {

    BudgetService budgetService;

    public BudgetController (BudgetService budgetService){
        this.budgetService = budgetService;
    }

    @GetMapping("/categories")
    public Iterable<BudgetCategory> getBudgetCategoryList(){
        return this.budgetService.getBudgetCategoryList();
    }

    @PostMapping("/newCategory")
    public BudgetCategory newBudgetCategory(@RequestBody NewBudgetCategoryRequestDTO requestDTO){
        return this.budgetService.newBudgetCategory(requestDTO);
    }

}
