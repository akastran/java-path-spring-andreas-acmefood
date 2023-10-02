package gr.nbg.acmefood.api.controller;

import gr.nbg.acmefood.api.domain.Account;
import gr.nbg.acmefood.api.mapper.BaseMapper;
import gr.nbg.acmefood.api.mapper.AccountMapper;
import gr.nbg.acmefood.api.service.BaseService;
import gr.nbg.acmefood.api.service.AccountService;
import gr.nbg.acmefood.api.transfer.ApiResponse;
import gr.nbg.acmefood.api.transfer.resource.AccountResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController extends BaseController<Account, AccountResource> {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @Override
    public BaseService<Account, Long> getBaseService() {
        return accountService;
    }

    @Override
    public BaseMapper<Account, AccountResource> getMapper() {
        return accountMapper;
    }

    @GetMapping(params = "serial")
    public ResponseEntity<ApiResponse<AccountResource>> findById(@RequestParam Long id) {
        final AccountResource accountResource = getMapper().toResource(accountService.get(id));
        return ResponseEntity.ok(ApiResponse.<AccountResource>builder().data(accountResource).build());
    }
}
