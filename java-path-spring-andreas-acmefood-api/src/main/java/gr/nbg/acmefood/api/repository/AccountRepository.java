package gr.nbg.acmefood.api.repository;

import gr.nbg.acmefood.api.domain.Account;
import gr.nbg.acmefood.api.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Store findByUserId(String userId);
}
