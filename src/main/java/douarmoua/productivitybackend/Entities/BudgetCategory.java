package douarmoua.productivitybackend.Entities;

import jakarta.persistence.*;

@Entity
public class BudgetCategory {

    public BudgetCategory() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column (unique = true)
    String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "BudgetCategory{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
