package com.project.account.gatewey.out;

import com.project.account.AccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<AccountDto> save(AccountDto accountDto);

    Mono<AccountDto> update(AccountDto accountDto);

    Flux<AccountDto> findAll(String bankId, String type);

    Mono<AccountDto> findById(String id);

    Mono<Boolean> deleteById(String id);
}
