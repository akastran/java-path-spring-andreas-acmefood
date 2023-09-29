package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Address;

import java.util.List;

public interface AddressService extends BaseService<Address, Long>  {

    Address create(final Address address);

    Address findByStoreName(String storeName);

    List<Address> findByUserId(String userId);

    Address findByAddressId(Long addressId);
}
