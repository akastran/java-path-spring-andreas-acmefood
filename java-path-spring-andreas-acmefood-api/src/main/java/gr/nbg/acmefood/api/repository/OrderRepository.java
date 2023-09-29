package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getOrderByUserId(String userId);

    List<Order> getOrderByStoreId(Long storeId);

    List<Order> getOrderByStoreName(String storeName);

    Order getOrder(Long orderId);
}
