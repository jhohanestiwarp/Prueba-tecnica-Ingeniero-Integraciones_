package com.project.accountlengthrule;

import com.project.bankaccountlengthrule.BankAccountLengthRule;
import org.springframework.stereotype.Component;

@Component
public class AccountLengthRuleMapper {

    public AccountLengthRuleData toEntityData(BankAccountLengthRule bankAccountLengthRule, BankAccountLengthRule existing) {
        return AccountLengthRuleData.builder()
                .id(bankAccountLengthRule.getId())
                .bankId(existing != null ? existing.getBankId() : bankAccountLengthRule.getBankId())
                .minLen(bankAccountLengthRule.getMinLen())
                .maxLen(bankAccountLengthRule.getMaxLen())
                .createdAt(existing != null ? existing.getCreatedAt() : bankAccountLengthRule.getCreatedAt())
                .updatedAt(bankAccountLengthRule.getUpdatedAt())
                .build();
    }

    public BankAccountLengthRule toDomainModel(AccountLengthRuleData accountLengthRuleData) {
        if (accountLengthRuleData == null) {
            return null;
        }

        return BankAccountLengthRule.builder()
                .id(accountLengthRuleData.getId())
                .bankId(accountLengthRuleData.getBankId())
                .minLen(accountLengthRuleData.getMinLen())
                .maxLen(accountLengthRuleData.getMaxLen())
                .createdAt(accountLengthRuleData.getCreatedAt())
                .updatedAt(accountLengthRuleData.getUpdatedAt())
                .build();
    }
}
