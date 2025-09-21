package com.project.bank.services;

import com.project.account.AccountDto;
import com.project.accounts.AccountUseCaseImpl;
import com.project.bank.BankDto;
import com.project.bank.BankUseCaseImp;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankService {
    private final BankUseCaseImp bankUseCaseImp;

    public BankService(BankUseCaseImp bankUseCaseImp) {
        this.bankUseCaseImp = bankUseCaseImp;
    }

    public Mono<BankDto> createBank(BankDto bankDto) {
        return bankUseCaseImp.createBank(bankDto);
    }

    public Mono<BankDto> updateBank(Long id, BankDto bankDto) {
        return bankUseCaseImp.updateBank(id, bankDto);
    }

    public Flux<BankDto> getAllBanks() {
        return bankUseCaseImp.getAllBanks();
    }

    public Mono<Boolean> deleteBank(Long id) {
        return bankUseCaseImp.deleteBank(id);
    }
}
