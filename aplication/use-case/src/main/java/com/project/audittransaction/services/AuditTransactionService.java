package com.project.audittransaction.services;

import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.audittransaction.AuditTransaction;
import com.project.audittransaction.AuditTransactionUseCaseImp;
import com.project.audittransaction.dto.AuditTransactionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuditTransactionService {
    private final AuditTransactionUseCaseImp auditTransactionUseCaseImp;

    public AuditTransactionService(AuditTransactionUseCaseImp auditTransactionUseCaseImp) {
        this.auditTransactionUseCaseImp = auditTransactionUseCaseImp;
    }

    public Mono<AuditTransaction> save(AuditTransaction auditTransaction) {
        return auditTransactionUseCaseImp.save(auditTransaction);
    }

    public Flux<AuditTransactionDto> getAllAccountTypes() {
        return auditTransactionUseCaseImp.getAllAuditTransactions();
    }
}
