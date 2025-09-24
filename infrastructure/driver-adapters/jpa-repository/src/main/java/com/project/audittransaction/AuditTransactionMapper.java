package com.project.audittransaction;

import com.project.accountypes.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AuditTransactionMapper {

    public AuditTransactionData toEntityData(AuditTransaction auditTransaction) {
        return AuditTransactionData.builder()
                .id(auditTransaction.getId())
                .userId(auditTransaction.getUserId())
                .action(auditTransaction.getAction())
                .entity(auditTransaction.getEntity())
                .entityId(auditTransaction.getEntityId())
                .channel(auditTransaction.getChannel())
                .createdAt(auditTransaction.getCreatedAt())
                .build();
    }

    public AuditTransaction toDomainModel(AuditTransactionData auditTransactionData) {
        if (auditTransactionData == null) {
            return null;
        }

        return AuditTransaction.builder()
                .id(auditTransactionData.getId())
                .userId(auditTransactionData.getUserId())
                .action(auditTransactionData.getAction())
                .entity(auditTransactionData.getEntity())
                .entityId(auditTransactionData.getEntityId())
                .channel(auditTransactionData.getChannel())
                .createdAt(auditTransactionData.getCreatedAt())
                .build();
    }
}
