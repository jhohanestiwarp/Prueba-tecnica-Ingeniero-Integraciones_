package com.project.audittransaction;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditTransactionDataRepository extends ReactiveCrudRepository<AuditTransactionData, Long> {
}
