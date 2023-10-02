package gr.nbg.acmefood.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "STORES", indexes = {@Index(columnList = "name")})
@Table(name = "STORES")
@SequenceGenerator(name = "idGenerator", sequenceName = "STORES_SEQ", initialValue = 1, allocationSize = 1)
public class Store extends BaseModel{

//    @NotNull
//    @Column(length = 50, nullable = false, unique = true)
//    private String name;

    @NotNull
    private StoreCategory category;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private Set<Product> products = new HashSet<>();
}
