package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Store;

public interface StoreService extends BaseService<Store, Long>  {

    Store create(final Store store);

//    Store findByName(String name);

    Store get(Long storeId);
}
