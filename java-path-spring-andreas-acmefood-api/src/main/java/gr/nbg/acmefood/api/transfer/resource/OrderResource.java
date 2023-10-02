package gr.nbg.acmefood.api.transfer.resource;

import gr.nbg.acmefood.api.domain.OrderItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderResource extends BaseResource {
    private Long account_id;
    private Long store_id;
    private Date submitDate;
    private Set<OrderItem> orderItemSet;
    private BigDecimal cost;
}
