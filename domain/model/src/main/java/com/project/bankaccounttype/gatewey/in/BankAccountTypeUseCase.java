package com.project.bankaccounttype.gatewey.in;

import com.project.accountypes.AccountType;
import com.project.bankaccounttype.BankAccountType;
import com.project.bankaccounttype.dto.BankAccountTypeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountTypeUseCase {
    Mono<BankAccountType> createBankAccountType(BankAccountType bankAccountType);
    Flux<BankAccountType> getAllBankAccountTypes();
    Mono<Boolean> deleteBankAccountType(Long id);
}
