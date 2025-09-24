package com.project.accountypes.gatewey.out;

import com.project.accountypes.AccountType;
import com.project.bank.Bank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountTypeRepository {
    Mono<AccountType> save(AccountType accountType);
    Mono<AccountType> update(AccountType accountType, AccountType existing);
    Flux<AccountType> findAll();
    Mono<AccountType> findById(Long id);
    Mono<Boolean> deleteById(Long id);
}

