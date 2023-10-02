package gr.nbg.acmefood.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
public class Product extends BaseModel{

    @NotNull
    @Column(length = 50, nullable = false)
    private String description;

    @NotNull
    private ProductCategory category;

    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

}
