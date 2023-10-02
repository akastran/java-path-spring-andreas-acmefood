package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Order;
import gr.nbg.acmefood.api.domain.Store;

import java.util.List;

public interface OrderService extends BaseService<Order, Long>  {

    Order create(final Order order);

//    List<Order> getOrderByUserId(String userId);

    List<Order> getOrderByStoreId(Long storeId);

//    List<Order> getOrderByStoreName(String storeName);

    Order get(Long orderId);
}
