package gr.nbg.acmefood.api.transfer.resource;

import gr.nbg.acmefood.api.domain.StoreCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class StoreResource extends BaseResource {

    private StoreCategory category;
    private String name;
}
