package douarmoua.productivitybackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column (unique = true)
    String categoryName;
}
