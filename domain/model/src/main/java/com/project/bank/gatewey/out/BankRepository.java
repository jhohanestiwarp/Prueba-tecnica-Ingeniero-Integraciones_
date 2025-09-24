package com.project.bank.gatewey.out;

import com.project.bank.Bank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankRepository {
    Mono<Bank> save(Bank bankDto);
    Mono<Bank> update(Bank bankDto, Bank existing);
    Flux<Bank> findAll();
    Mono<Bank> findById(Long id);
    Mono<Boolean> deleteById(Long id);
}

