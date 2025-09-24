package com.project.audittransaction.gatewey.out;

import com.project.audittransaction.AuditTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuditTransactionRepository {
    Mono<AuditTransaction> save(AuditTransaction auditTransaction);
    Flux<AuditTransaction> findAll();
}

