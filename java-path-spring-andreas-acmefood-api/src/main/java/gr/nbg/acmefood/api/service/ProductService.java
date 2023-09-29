package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Product;

public interface ProductService extends BaseService<Product, Long> {

        Product create(final Product product);

        Product findByDescription(String description);

        Product findByProductId(Long productId);
}
