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
@Table(indexes = {@Index(columnList = "userId")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel{

    @NotNull
    @Column(length = 20, nullable = false, unique = true)
    private String userId;

    @NotNull(message = "{firstname.null}")
    @Column(length = 20, nullable = false)
    private String firstname;

    @Column(length = 30)
    private String lastname;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();
}
