package com.project.bankaccounttype.services;

import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.bankaccounttype.BankAccountType;
import com.project.bankaccounttype.BankAccountTypeUseCaseImp;
import com.project.bankaccounttype.dto.BankAccountTypeDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountTypeService {
    private final BankAccountTypeUseCaseImp bankAccountTypeUseCaseImp;

    public BankAccountTypeService(BankAccountTypeUseCaseImp bankAccountTypeUseCaseImp) {
        this.bankAccountTypeUseCaseImp = bankAccountTypeUseCaseImp;
    }

    public Mono<BankAccountType> createAccountType(BankAccountType bankAccountType) {
        return bankAccountTypeUseCaseImp.createBankAccountType(bankAccountType);
    }

    public Flux<BankAccountType> getAllAccountTypes() {
        return bankAccountTypeUseCaseImp.getAllBankAccountTypes();
    }

    public Mono<Boolean> deleteAccountType(Long id) {
        return bankAccountTypeUseCaseImp.deleteBankAccountType(id);
    }
}
