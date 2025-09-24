package com.project.bankaccounttype.gatewey.out;

import com.project.bankaccounttype.BankAccountType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountTypeRepository {
    Mono<BankAccountType> save(BankAccountType bankAccountType);
    Flux<BankAccountType> findByBankId(Long id);
    Flux<BankAccountType> findAll();
    Mono<Boolean> deleteById(Long id);
}

