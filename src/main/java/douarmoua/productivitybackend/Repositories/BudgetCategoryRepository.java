package douarmoua.productivitybackend.Repositories;

import douarmoua.productivitybackend.Entities.BudgetCategory;
import org.springframework.data.repository.CrudRepository;

public interface BudgetCategoryRepository extends CrudRepository<BudgetCategory, String> {
}
