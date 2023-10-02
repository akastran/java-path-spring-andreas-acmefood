package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Order;

import java.util.List;

public interface OrderService extends BaseService<Order, Long>  {

    Order create(final Order order);

    List<Order> getOrderByStoreId(Long storeId);

    Order get(Long orderId);
}
