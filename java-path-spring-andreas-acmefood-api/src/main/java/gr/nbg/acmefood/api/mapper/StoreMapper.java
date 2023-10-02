package gr.nbg.acmefood.api.mapper;

import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.transfer.resource.StoreResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface StoreMapper extends BaseMapper<Store, StoreResource> {

    StoreResource toResource(Store domain);
}
