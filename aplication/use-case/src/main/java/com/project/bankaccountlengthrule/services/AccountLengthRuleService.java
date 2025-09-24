package com.project.bankaccountlengthrule.services;

import com.project.bankaccountlengthrule.AccountLengthRuleUseCaseImp;
import com.project.bankaccountlengthrule.BankAccountLengthRule;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountLengthRuleService {
    private final AccountLengthRuleUseCaseImp accountLengthRuleUseCaseImp;

    public AccountLengthRuleService(AccountLengthRuleUseCaseImp accountLengthRuleUseCaseImp) {
        this.accountLengthRuleUseCaseImp = accountLengthRuleUseCaseImp;
    }

    public Mono<BankAccountLengthRule> createAccountLengthRule(BankAccountLengthRule bankAccountLengthRule) {
        return accountLengthRuleUseCaseImp.createAccountLengthRule(bankAccountLengthRule);
    }

    public Mono<BankAccountLengthRule> updateAccountLengthRule(Long id, BankAccountLengthRule bankAccountLengthRule) {
        return accountLengthRuleUseCaseImp.updateAccountLengthRule(id, bankAccountLengthRule);
    }

    public Mono<BankAccountLengthRule> getById(Long id) {
        return accountLengthRuleUseCaseImp.findAccountLengthRuleById(id);
    }

    public Flux<BankAccountLengthRule> getAllBanks() {
        return accountLengthRuleUseCaseImp.getAllAccountLengthRules();
    }

    public Mono<Boolean> deleteBank(Long id) {
        return accountLengthRuleUseCaseImp.deleteAccountLengthRule(id);
    }
}
