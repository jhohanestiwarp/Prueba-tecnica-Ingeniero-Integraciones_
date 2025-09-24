package com.project.account.gatewey.in;

import com.project.account.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountUseCase {

    Mono<Account> createAccount(Account account, String username, String channel);

    Mono<Account> updateAccount(Long id, Account account);

    Flux<Account> getAllAccounts(Long bankId, String type);

    Mono<Boolean> deleteAccount(Long id);
}
