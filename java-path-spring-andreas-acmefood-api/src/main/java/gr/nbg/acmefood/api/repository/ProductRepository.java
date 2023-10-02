package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDescription(String description);

}
