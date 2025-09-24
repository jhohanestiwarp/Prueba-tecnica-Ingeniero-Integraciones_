package com.project.accounttype.services;

import com.project.accounttype.AccountTypeUseCaseImp;
import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.bankaccountlengthrule.BankAccountLengthRule;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTypeService {
    private final AccountTypeUseCaseImp accountTypeUseCaseImp;

    public AccountTypeService(AccountTypeUseCaseImp accountTypeUseCaseImp) {
        this.accountTypeUseCaseImp = accountTypeUseCaseImp;
    }

    public Mono<AccountType> createAccountType(AccountType accountType) {
        return accountTypeUseCaseImp.createAccountType(accountType);
    }

    public Mono<AccountType> updateAccountType(Long id, AccountType accountType) {
        return accountTypeUseCaseImp.updateAccountType(id, accountType);
    }

    public Mono<AccountTypeDto> getById(Long id) {
        return accountTypeUseCaseImp.findAccountTypeById(id);
    }

    public Flux<AccountTypeDto> getAllAccountTypes() {
        return accountTypeUseCaseImp.getAllAccountTypes();
    }

    public Mono<Boolean> deleteAccountType(Long id) {
        return accountTypeUseCaseImp.deleteAccountType(id);
    }
}
