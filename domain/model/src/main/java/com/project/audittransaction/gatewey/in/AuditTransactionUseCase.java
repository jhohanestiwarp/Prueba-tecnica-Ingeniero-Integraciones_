package com.project.audittransaction.gatewey.in;

import com.project.audittransaction.AuditTransaction;
import com.project.audittransaction.dto.AuditTransactionDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuditTransactionUseCase {
    Mono<AuditTransaction> save(AuditTransaction auditTransaction);
    Flux<AuditTransactionDto> getAllAuditTransactions();
}
