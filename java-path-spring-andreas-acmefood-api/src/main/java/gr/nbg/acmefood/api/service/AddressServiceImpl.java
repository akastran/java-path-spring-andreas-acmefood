package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Address;
import gr.nbg.acmefood.api.repository.AddressRepository;
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
public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class)
    public Address create(final Address address) {
        logger.trace("Creating {} assigned to {}.", address);
        return getRepository().save(address);
    }

    @Override
    public Address findByStoreName(String storeName) {
        return addressRepository.findByStoreName(storeName);
    }

    @Override
    public List<Address> findByUserId(String userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public Address findByAddressId(Long addressId) { return addressRepository.findByAddressId(addressId); }
}
