package gr.nbg.acmefood.api.mapper;

import gr.nbg.acmefood.api.domain.Order;
import gr.nbg.acmefood.api.transfer.resource.OrderResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface OrderMapper extends BaseMapper<Order, OrderResource> {

    OrderResource toResource(Order domain);

    Order toDomain(OrderResource resource);
}
