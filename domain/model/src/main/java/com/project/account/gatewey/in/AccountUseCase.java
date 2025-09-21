package com.project.account.gatewey.in;

import com.project.account.AccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountUseCase {

    Mono<AccountDto> createAccount(AccountDto accountDto);

    Mono<AccountDto> updateAccount(Long id, AccountDto accountDto);

    Flux<AccountDto> getAllAccounts(Long bankId, String type);

    Mono<Boolean> deleteAccount(Long id);
}
