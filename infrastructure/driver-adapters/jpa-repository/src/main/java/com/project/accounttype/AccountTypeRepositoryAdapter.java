package com.project.accounttype;

import com.project.accountypes.AccountType;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.bank.Bank;
import com.project.bank.gatewey.out.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AccountTypeRepositoryAdapter implements AccountTypeRepository {

    private final AccountTypeDataRepository repository;
    private final AccountTypeMapper mapper;

    @Override
    public Mono<AccountType> save(AccountType accountType) {
        return repository.save(mapper.toEntityData(accountType, null))
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<AccountType> update(AccountType accountType, AccountType existing) {
        return repository.save(mapper.toEntityData(accountType, existing))
                .map(mapper::toDomainModel);
    }

    @Override
    public Flux<AccountType> findAll() {
        return repository.findAll().map(mapper::toDomainModel);
    }

    @Override
    public Mono<AccountType> findById(Long id) {
        return repository.findById(id).map(mapper::toDomainModel);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.findById(id)
                .flatMap(existing -> repository.deleteById(id).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}