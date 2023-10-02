package gr.nbg.acmefood.api.mapper;

import gr.nbg.acmefood.api.domain.Account;
import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.transfer.resource.AccountResource;
import gr.nbg.acmefood.api.transfer.resource.StoreResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface AccountMapper extends BaseMapper<Account, AccountResource> {

    AccountResource toResource(Account domain);
}
