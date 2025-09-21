package com.project.bank.gatewey.out;

import com.project.bank.BankDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankRepository {
    Mono<BankDto> save(BankDto bankDto);
    Mono<BankDto> update(BankDto bankDto);
    Flux<BankDto> findAll();
    Mono<BankDto> findById(Long id);
    Mono<Boolean> deleteById(Long id);
}

