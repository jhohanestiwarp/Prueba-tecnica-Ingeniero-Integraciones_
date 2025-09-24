package com.project.bankaccountlengthrule.gatewey.out;

import com.project.bankaccountlengthrule.BankAccountLengthRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountLengthRuleRepository {
    Mono<BankAccountLengthRule> save(BankAccountLengthRule bankAccountLengthRule);
    Mono<BankAccountLengthRule> update(BankAccountLengthRule bankAccountLengthRule, BankAccountLengthRule existing);
    Flux<BankAccountLengthRule> findAll();
    Mono<BankAccountLengthRule> findById(Long id);
    Mono<BankAccountLengthRule> findByBankId(Long id);
    Mono<Boolean> deleteById(Long id);
}

