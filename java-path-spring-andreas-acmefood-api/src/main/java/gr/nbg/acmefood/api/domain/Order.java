package gr.nbg.acmefood.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS", indexes = {@Index(columnList = "store_id"),
//        @Index(columnList = "STORES.name"),
        @Index(columnList = "account_id")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel{

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("account_id")
    private Account account;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("store_id")
    private Store store;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date submitDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final Set<OrderItem> orderItems = new HashSet<>();

    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal cost;
}
