package com.project.bankaccountlengthrule.gatewey.in;

import com.project.bankaccountlengthrule.BankAccountLengthRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountLengthRuleUseCase {
    Mono<BankAccountLengthRule> createAccountLengthRule(BankAccountLengthRule bankAccountLengthRule);
    Mono<BankAccountLengthRule> updateAccountLengthRule(Long id, BankAccountLengthRule bankAccountLengthRule);
    Flux<BankAccountLengthRule> getAllAccountLengthRules();
    Mono<BankAccountLengthRule> findAccountLengthRuleById(Long id);
    Mono<Boolean> deleteAccountLengthRule(Long id);
}
