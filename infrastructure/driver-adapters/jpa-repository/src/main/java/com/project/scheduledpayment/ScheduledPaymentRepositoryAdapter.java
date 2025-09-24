package com.project.scheduledpayment;

import com.project.accountypes.AccountType;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.scheduledpayment.gatewey.out.ScheduledPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ScheduledPaymentRepositoryAdapter implements ScheduledPaymentRepository {

    private final ScheduledPaymentDataRepository repository;
    private final ScheduledPaymentMapper mapper;

    @Override
    public Mono<ScheduledPayment> save(ScheduledPayment scheduledPayment) {
        return repository.save(mapper.toEntityData(scheduledPayment))
                .map(mapper::toDomainModel);
    }

    @Override
    public Flux<ScheduledPayment> findByOriginAccountId(Long id) {
        return repository.findByOriginAccountId(id).map(mapper::toDomainModel);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.findById(id)
                .flatMap(existing -> repository.deleteById(id).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}