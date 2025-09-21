package com.project.account;

import com.project.account.gatewey.out.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

    private final AccountDataRepository repository;
    private final AccountMapper mapper;

    @Override
    public Mono<AccountDto> save(AccountDto accountDto) {
        return mapper.toData(accountDto)
                .flatMap(repository::save)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<AccountDto> update(AccountDto accountDto) {
        return mapper.toData(accountDto)
                .flatMap(repository::save)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<AccountDto> findAll(String bankId, String type) {
        if (bankId != null && !bankId.isBlank() && type != null && !type.isBlank()) {
            return repository.findAllByBankAndType(bankId, type)
                    .map(mapper::toDomain);
        } else if (bankId != null && !bankId.isBlank()) {
            return repository.findAllByBank(bankId)
                    .map(mapper::toDomain);
        } else if (type != null && !type.isBlank()) {
            return repository.findAllByType(type)
                    .map(mapper::toDomain);
        } else {
            return repository.findAll()
                    .map(mapper::toDomain);
        }
    }

    @Override
    public Mono<AccountDto> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Boolean> deleteById(String id) {
        return repository.findById(id)
                .flatMap(account -> repository.deleteById(id).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}
