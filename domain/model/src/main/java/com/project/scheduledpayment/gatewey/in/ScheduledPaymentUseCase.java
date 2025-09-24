package com.project.scheduledpayment.gatewey.in;

import com.project.accountypes.AccountType;
import com.project.scheduledpayment.ScheduledPayment;
import com.project.scheduledpayment.dto.ScheduledPaymentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ScheduledPaymentUseCase {
    Mono<ScheduledPayment> createScheduledPayment(ScheduledPayment scheduledPayment);
    Flux<ScheduledPayment> findScheduledPaymentByOriginAccountId(Long id);
    Mono<Boolean> deleteScheduledPayment(Long id);
}
