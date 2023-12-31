package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Account;

public interface AccountService extends BaseService<Account, Long>  {

    Account create(final Account account);

    Account get(Long accountId);
}
