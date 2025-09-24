package com.project.translate;

import com.project.bankaccountlengthrule.BankAccountLengthRule;
import com.project.bankaccountlengthrule.dto.BankAccountLengthRuleDto;

public class AccountLengthTranslate {
    public static BankAccountLengthRuleDto toDto(BankAccountLengthRule rule) {
        if (rule == null) return null;

        return BankAccountLengthRuleDto.builder()
                .id(rule.getId())
                .bankId(rule.getBankId())
                .minLen(rule.getMinLen())
                .maxLen(rule.getMaxLen())
                .build();
    }
}
