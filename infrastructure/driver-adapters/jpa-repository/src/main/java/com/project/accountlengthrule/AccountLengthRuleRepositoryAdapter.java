package com.project.accountlengthrule;

import com.project.bankaccountlengthrule.BankAccountLengthRule;
import com.project.bankaccountlengthrule.gatewey.out.AccountLengthRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AccountLengthRuleRepositoryAdapter implements AccountLengthRuleRepository {

    private final AccountLengthRuleDataRepository repository;
    private final AccountLengthRuleMapper mapper;

    @Override
    public Mono<BankAccountLengthRule> save(BankAccountLengthRule bankAccountLengthRule) {
        return repository.save(mapper.toEntityData(bankAccountLengthRule, null))
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<BankAccountLengthRule> update(BankAccountLengthRule bankAccountLengthRule, BankAccountLengthRule existing) {
        return repository.save(mapper.toEntityData(bankAccountLengthRule, existing))
                .map(mapper::toDomainModel);
    }

    @Override
    public Flux<BankAccountLengthRule> findAll() {
        return repository.findAll().map(mapper::toDomainModel);
    }

    @Override
    public Mono<BankAccountLengthRule> findById(Long id) {
        return repository.findById(id).map(mapper::toDomainModel);
    }

    @Override
    public Mono<BankAccountLengthRule> findByBankId(Long id) {
        return repository.findFirstByBankId(id).map(mapper::toDomainModel);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.findById(id)
                .flatMap(existing -> repository.deleteById(id).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}