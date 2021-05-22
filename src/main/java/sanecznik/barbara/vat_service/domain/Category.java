package sanecznik.barbara.vat_service.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String taxableItem;

    @Column (nullable = false)
    private BigDecimal taxPercentage;
}
