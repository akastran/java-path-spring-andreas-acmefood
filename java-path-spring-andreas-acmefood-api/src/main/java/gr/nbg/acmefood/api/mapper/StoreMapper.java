package gr.nbg.acmefood.api.mapper;

import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.transfer.resource.StoreResource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface StoreMapper extends BaseMapper<Store, StoreResource> {

    StoreResource toResource(Store domain);

    @Override
    default List<StoreResource> toResources(List<Store> stores) {
        return stores.stream().map(this::toResource).toList();
    }
}
