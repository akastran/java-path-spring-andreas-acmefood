package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByStoreName(String storeName);
    List<Address> findByUserId(String userId);
    Address findByAddressId(Long addressId);
}
