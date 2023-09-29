package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(String name);
}
