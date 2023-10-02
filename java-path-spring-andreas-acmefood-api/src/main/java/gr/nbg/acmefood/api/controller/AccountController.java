package gr.nbg.acmefood.api.controller;

import gr.nbg.acmefood.api.domain.Account;
import gr.nbg.acmefood.api.mapper.BaseMapper;
import gr.nbg.acmefood.api.mapper.AccountMapper;
import gr.nbg.acmefood.api.service.BaseService;
import gr.nbg.acmefood.api.service.AccountService;
import gr.nbg.acmefood.api.transfer.ApiResponse;
import gr.nbg.acmefood.api.transfer.resource.AccountResource;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AccountResource>> create(@RequestBody final AccountResource resource) {

        return ResponseEntity.ok(
                ApiResponse.<AccountResource>builder()
                        .data(getMapper().toResource(accountService.create(getMapper().toDomain(resource))))
//                        .data(getMapper().toResource(
//                                accountService.create(getMapper().toDomain(resource))))
                        .build());
    }
}
