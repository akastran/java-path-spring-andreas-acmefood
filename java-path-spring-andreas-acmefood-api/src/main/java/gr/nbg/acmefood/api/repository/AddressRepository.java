package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Address;
import gr.nbg.acmefood.api.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Store findByStore(Long storeId);
    Store findByAccount(Long accountId);
}
