package com.project.translate;

import com.project.audittransaction.AuditTransaction;
import com.project.audittransaction.dto.AuditTransactionDto;
import com.project.bankaccountlengthrule.BankAccountLengthRule;
import com.project.bankaccountlengthrule.dto.BankAccountLengthRuleDto;
import com.project.user.UserDto;

public class AuditTransactionTranslate {
    public static AuditTransactionDto toDto(AuditTransaction auditTransaction, UserDto user) {
        return AuditTransactionDto.builder()
                .id(auditTransaction.getId())
                .user(user)
                .action(auditTransaction.getAction())
                .entity(auditTransaction.getEntity())
                .entityId(auditTransaction.getEntityId())
                .channel(auditTransaction.getChannel())
                .createdAt(auditTransaction.getCreatedAt())
                .build();
    }
}
