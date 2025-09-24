package com.project.account.gatewey.out;

import com.project.account.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<Account> save(Account account);

    Mono<Account> update(Account account);

    Flux<Account> findAll(Long bankId, String type);

    Mono<Account> findById(Long id);

    Mono<Boolean> deleteById(Long id);
}
