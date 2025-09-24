package com.project.bank.gatewey.in;

import com.project.bank.Bank;
import com.project.bank.dto.BankDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankUseCase {
    Mono<Bank> createBank(Bank bankDto);
    Mono<Bank> updateBank(Long id, Bank bankDto);
    Flux<BankDto> getAllBanks();
    Mono<BankDto> findBankById(Long id);
    Mono<Boolean> deleteBank(Long id);
}
