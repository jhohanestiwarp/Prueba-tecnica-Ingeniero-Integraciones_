package com.project.accountypes.gatewey.in;

import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.bank.Bank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountTypeUseCase {
    Mono<AccountType> createAccountType(AccountType accountType);
    Mono<AccountType> updateAccountType(Long id, AccountType accountType);
    Flux<AccountTypeDto> getAllAccountTypes();
    Mono<AccountTypeDto> findAccountTypeById(Long id);
    Mono<Boolean> deleteAccountType(Long id);
}
