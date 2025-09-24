package com.project.bankaccountlengthrule;


import com.project.bankaccountlengthrule.gatewey.in.AccountLengthRuleUseCase;
import com.project.bankaccountlengthrule.gatewey.out.AccountLengthRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountLengthRuleUseCaseImp implements AccountLengthRuleUseCase {

    private final AccountLengthRuleRepository accountLengthRuleRepository;

    @Override
    public Mono<BankAccountLengthRule> createAccountLengthRule(BankAccountLengthRule bankAccountLengthRule) {

        bankAccountLengthRule.setCreatedAt(LocalDateTime.now());
        bankAccountLengthRule.setUpdatedAt(LocalDateTime.now());

        return accountLengthRuleRepository.findByBankId(bankAccountLengthRule.getBankId())
                .flatMap(existing -> Mono.<BankAccountLengthRule>error(
                        new IllegalStateException("El banco ya tiene una regla registrada"))
                )
                .switchIfEmpty(accountLengthRuleRepository.save(bankAccountLengthRule));
    }

    @Override
    public Mono<BankAccountLengthRule> updateAccountLengthRule(Long id, BankAccountLengthRule bankAccountLengthRule) {
        bankAccountLengthRule.setUpdatedAt(LocalDateTime.now());
        return accountLengthRuleRepository.findById(id)
                .flatMap(existing -> {
                    bankAccountLengthRule.setId(existing.getId());
                    return accountLengthRuleRepository.update(bankAccountLengthRule, existing);
                });
    }

    @Override
    public Flux<BankAccountLengthRule> getAllAccountLengthRules() {
        return accountLengthRuleRepository.findAll();
    }

    @Override
    public Mono<BankAccountLengthRule> findAccountLengthRuleById(Long id) {
        return accountLengthRuleRepository.findById(id);
    }

    @Override
    public Mono<Boolean> deleteAccountLengthRule(Long id) {
        return accountLengthRuleRepository.deleteById(id);
    }
}
