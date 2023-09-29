package gr.nbg.acmefood.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "storeId"), @Index(columnList = "accountId")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ADDRESSES_SEQ", initialValue = 1, allocationSize = 1)
public class Address extends BaseModel{

    @Column(length = 50, nullable = false)
    private String name;

    @NotNull(message = "{email.null}")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{email.format}")
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotNull(message = "{phone.null}")
    @Pattern(regexp = "^[0-9]{10}$", message = "{phone.format}")
    @Column(length = 50, nullable = false, unique = true)
    private String phone;

    @NotNull(message = "{address.null}")
    @Column(length = 50)
    @Size(max = 50, message = "{address.length}")
    private String streetAddress;

    @ToString.Exclude
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("storeId")
    private Store store;

    @ToString.Exclude
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("accountId")
    private Account account;
}
