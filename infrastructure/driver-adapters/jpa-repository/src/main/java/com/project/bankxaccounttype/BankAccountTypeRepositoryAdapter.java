package com.project.bankxaccounttype;

import com.project.accountypes.AccountType;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.bankaccounttype.BankAccountType;
import com.project.bankaccounttype.gatewey.out.BankAccountTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BankAccountTypeRepositoryAdapter implements BankAccountTypeRepository {

    private final BankAccountTypeDataRepository repository;
    private final BankAccountTypeMapper mapper;

    @Override
    public Mono<BankAccountType> save(BankAccountType accountType) {
        return repository.save(mapper.toEntityData(accountType, null))
                .map(mapper::toDomainModel);
    }

    @Override
    public Flux<BankAccountType> findAll() {
        return repository.findAll().map(mapper::toDomainModel);
    }

    @Override
    public Flux<BankAccountType> findByBankId(Long id) {
        return repository.findAllByBankId(id).map(mapper::toDomainModel);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.findById(id)
                .flatMap(existing -> repository.deleteById(id).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}