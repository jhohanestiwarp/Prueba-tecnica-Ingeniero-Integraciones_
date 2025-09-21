package com.project.bank;

import com.project.bank.gatewey.out.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BankRepositoryAdapter implements BankRepository {

    private final BankDataRepository repository;
    private final BankMapper mapper;

    @Override
    public Mono<BankDto> save(BankDto bankDto) {
        return repository.save(mapper.toEntityData(bankDto))
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<BankDto> update(BankDto bankDto) {
        return repository.save(mapper.toEntityData(bankDto))
                .map(mapper::toDomainModel);
    }

    @Override
    public Flux<BankDto> findAll() {
        return repository.findAll().map(mapper::toDomainModel);
    }

    @Override
    public Mono<BankDto> findById(Long id) {
        return repository.findById(id).map(mapper::toDomainModel);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.findById(id)
                .flatMap(existing -> repository.deleteById(id).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}