package douarmoua.productivitybackend.Services;

import douarmoua.productivitybackend.Entities.BudgetCategory;
import douarmoua.productivitybackend.Repositories.BudgetCategoryRepository;
import douarmoua.productivitybackend._DTOs.NewBudgetCategoryRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BudgetService {
    BudgetCategoryRepository budgetCategoryRepository;

    public BudgetService(BudgetCategoryRepository budgetCategoryRepository){
        this.budgetCategoryRepository = budgetCategoryRepository;
    }

    public Iterable<BudgetCategory> getBudgetCategoryList(){
        return this.budgetCategoryRepository.findAll();
    }
    public BudgetCategory newBudgetCategory(NewBudgetCategoryRequestDTO requestDTO) {
        BudgetCategory newBudgetCategory = new BudgetCategory();
        newBudgetCategory.setCategoryName(requestDTO.categoryName);
        try {
            return this.budgetCategoryRepository.save(newBudgetCategory);
        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
}
