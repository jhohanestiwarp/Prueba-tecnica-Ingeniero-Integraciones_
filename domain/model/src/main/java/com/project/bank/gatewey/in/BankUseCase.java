package com.project.bank.gatewey.in;

import com.project.bank.BankDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankUseCase {
    Mono<BankDto> createBank(BankDto bankDto);
    Mono<BankDto> updateBank(Long id, BankDto bankDto);
    Flux<BankDto> getAllBanks();
    Mono<BankDto> findBankById(Long id);
    Mono<Boolean> deleteBank(Long id);
}
