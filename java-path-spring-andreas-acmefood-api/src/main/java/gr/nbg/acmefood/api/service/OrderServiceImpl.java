package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Order;
import gr.nbg.acmefood.api.repository.OrderRepository;
import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    private final OrderRepository orderRepository;
    private final StoreService storeService;

    @Override
    public JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class)
    public Order create(final Order order) {
        logger.trace("Creating {} assigned to {}.", order);
        return getRepository().save(order);
    }

    @Override
    public List<Order> getOrderByStoreId(Long storeId) {

        Store store = storeService.get(storeId);
        return orderRepository.getOrderByStoreId(store.getId());
    }

}
