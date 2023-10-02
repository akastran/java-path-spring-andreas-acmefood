package gr.nbg.acmefood.api.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class AccountResource extends BaseResource {

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String streetAddress;
}
