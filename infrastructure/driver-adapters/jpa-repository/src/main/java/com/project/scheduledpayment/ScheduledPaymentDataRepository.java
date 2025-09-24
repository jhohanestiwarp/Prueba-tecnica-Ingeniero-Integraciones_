package com.project.scheduledpayment;

import com.project.bankxaccounttype.BankAccountTypeData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ScheduledPaymentDataRepository extends ReactiveCrudRepository<ScheduledPaymentData, Long> {
    Flux<ScheduledPaymentData> findByOriginAccountId(Long id);
}
