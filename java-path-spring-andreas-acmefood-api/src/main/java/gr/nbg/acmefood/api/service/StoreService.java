package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.domain.StoreCategory;

import java.util.List;

public interface StoreService extends BaseService<Store, Long>  {

    Store create(final Store store);

    Store findByName(String name);

    Store get(Long storeId);

    List<Store> findStoreByCategory(StoreCategory category);
}
