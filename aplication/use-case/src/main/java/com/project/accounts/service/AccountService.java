package com.project.accounts.service;

import com.project.account.AccountDto;
import com.project.accounts.AccountUseCaseImpl;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountUseCaseImpl accountUseCase;

    public AccountService(AccountUseCaseImpl accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    public Mono<AccountDto> createAccount(AccountDto accountDto) {
        return accountUseCase.createAccount(accountDto);
    }

    public Mono<AccountDto> updateAccount(Long id, AccountDto accountDto) {
        return accountUseCase.updateAccount(id, accountDto);
    }

    public Flux<AccountDto> getAllAccounts(Long bankId, String type) {
        return accountUseCase.getAllAccounts(bankId, type);
    }

    public Mono<Boolean> deleteAccount(Long id) {
        return accountUseCase.deleteAccount(id);
    }
}
