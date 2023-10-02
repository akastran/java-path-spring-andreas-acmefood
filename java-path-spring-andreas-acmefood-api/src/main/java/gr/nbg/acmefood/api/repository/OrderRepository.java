package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getOrderByStoreId(Long storeId);

}
