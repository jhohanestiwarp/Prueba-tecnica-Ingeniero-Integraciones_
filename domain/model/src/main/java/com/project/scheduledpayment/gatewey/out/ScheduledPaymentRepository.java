package com.project.scheduledpayment.gatewey.out;

import com.project.accountypes.AccountType;
import com.project.scheduledpayment.ScheduledPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ScheduledPaymentRepository {
    Mono<ScheduledPayment> save(ScheduledPayment scheduledPayment);
    Flux<ScheduledPayment> findByOriginAccountId(Long id);
    Mono<Boolean> deleteById(Long id);
}

