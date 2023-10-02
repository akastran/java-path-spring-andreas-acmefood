package gr.nbg.acmefood.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
//@Table(name = "ACCOUNTS", indexes = {@Index(columnList = "userId")})
@Table(name = "ACCOUNTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel{

    @NotNull(message = "{firstname.null}")
    @Column(length = 20, nullable = false)
    private String firstname;

    @Column(length = 30)
    private String lastname;

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
}
