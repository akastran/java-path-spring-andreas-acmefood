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
@Table(name = "ORDER_ITEMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDER_ITEMS_SEQ", initialValue = 1, allocationSize = 1)
public class OrderItem  extends BaseModel{

    @ToString.Exclude
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("product_id")
    private Product product;

    @ToString.Exclude
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("order_id")
    private Order order;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;

    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
}
