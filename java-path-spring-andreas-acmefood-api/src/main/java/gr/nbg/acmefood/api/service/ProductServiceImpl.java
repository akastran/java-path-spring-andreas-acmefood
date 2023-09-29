package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Product;
import gr.nbg.acmefood.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class)
    public Product create(final Product product) {
        logger.trace("Creating {} assigned to {}.", product);
        return getRepository().save(product);
    }

    @Override
    public Product findByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    @Override
    public Product findByProductId(Long productId) {
        return productRepository.findByProductId(productId);
    }
}
