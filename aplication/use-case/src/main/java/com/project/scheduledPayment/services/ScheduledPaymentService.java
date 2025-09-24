package com.project.scheduledPayment.services;

import com.project.scheduledPayment.ScheduledPaymentUseCaseImp;
import com.project.scheduledpayment.ScheduledPayment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ScheduledPaymentService {
    private final ScheduledPaymentUseCaseImp scheduledPaymentUseCaseImp;

    public ScheduledPaymentService(ScheduledPaymentUseCaseImp scheduledPaymentUseCaseImp) {
        this.scheduledPaymentUseCaseImp = scheduledPaymentUseCaseImp;
    }

    public Mono<ScheduledPayment> createScheduledPayment(ScheduledPayment scheduledPayment) {
        return scheduledPaymentUseCaseImp.createScheduledPayment(scheduledPayment);
    }

    public Flux<ScheduledPayment> getAllScheduledPayments(Long id) {
        return scheduledPaymentUseCaseImp.findScheduledPaymentByOriginAccountId(id);
    }

    public Mono<Boolean> deleteScheduledPayment(Long id) {
        return scheduledPaymentUseCaseImp.deleteScheduledPayment(id);
    }
}
