package com.project.account;

import com.project.account.gatewey.out.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

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
    public Flux<AccountDto> findAll(Long bankId, String type) {
        if (bankId != null) {
            return repository.findAllByBankIdAndAccountTypeId(bankId, type)
                    .map(mapper::toDomain);
        } else if (bankId != null) {
            return repository.findAllByBankId(bankId)
                    .map(mapper::toDomain);
        } else if (type != null && !type.isBlank()) {
            return repository.findAllByAccountTypeId(type)
                    .map(mapper::toDomain);
        } else {
            return repository.findAll()
                    .map(mapper::toDomain)
                    .filter(Objects::nonNull);
        }
    }

    @Override
    public Mono<AccountDto> findById(Long id) {
        return repository.findById(id.toString())
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.findById(id.toString())
                .flatMap(account -> repository.deleteById(id.toString()).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}
