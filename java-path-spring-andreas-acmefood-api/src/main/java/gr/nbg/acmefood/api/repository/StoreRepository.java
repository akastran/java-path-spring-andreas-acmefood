package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.domain.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(String name);

    List<Store> findStoreByCategory(StoreCategory category);

}
