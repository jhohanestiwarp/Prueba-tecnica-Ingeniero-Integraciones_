package com.project.bank.services;

import com.project.bank.Bank;
import com.project.bank.BankUseCaseImp;
import com.project.bank.dto.BankDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankService {
    private final BankUseCaseImp bankUseCaseImp;

    public BankService(BankUseCaseImp bankUseCaseImp) {
        this.bankUseCaseImp = bankUseCaseImp;
    }

    public Mono<Bank> createBank(Bank bankDto) {
        return bankUseCaseImp.createBank(bankDto);
    }

    public Mono<Bank> updateBank(Long id, Bank bankDto) {
        return bankUseCaseImp.updateBank(id, bankDto);
    }

    public Mono<BankDto> getById(Long id) {
        return bankUseCaseImp.findBankById(id);
    }

    public Flux<BankDto> getAllBanks() {
        return bankUseCaseImp.getAllBanks();
    }

    public Mono<Boolean> deleteBank(Long id) {
        return bankUseCaseImp.deleteBank(id);
    }
}
