package gr.nbg.acmefood.api.service;

import gr.nbg.acmefood.api.domain.Account;
import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class)
    public Account create(final Account account) {
        logger.trace("Creating {} assigned to {}.", account);
        return getRepository().save(account);
    }

    @Override
    public Account findByUserId(String userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Account findByAccountId(Long accountId) {
        return accountRepository.findByAccountId(accountId);
    }
}
