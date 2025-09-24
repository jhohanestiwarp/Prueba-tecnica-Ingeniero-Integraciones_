package com.project.translate;

import com.project.accountypes.dto.AccountTypeDto;
import com.project.bank.Bank;
import com.project.bank.dto.BankDto;
import com.project.bankaccountlengthrule.BankAccountLengthRule;
import com.project.bankaccountlengthrule.dto.BankAccountLengthRuleDto;
import com.project.bankaccounttype.dto.BankAccountTypeDto;

import java.util.List;

public class BankAndAccountLengthTranslate {

    public static BankDto toDto(Bank bank, BankAccountLengthRuleDto rule, List<AccountTypeDto> accountTypeDtos) {
        if (bank == null) return null;

        return BankDto.builder()
                .id(bank.getId())
                .code(bank.getCode())
                .nit(bank.getNit())
                .name(bank.getName())
                .isActive(bank.getIsActive())
                .accountLengthRule(rule)
                .accountTypes(accountTypeDtos)
                .build();
    }

    public static Bank toEntity(BankDto dto) {
        if (dto == null) return null;

        return Bank.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .nit(dto.getNit())
                .name(dto.getName())
                .isActive(dto.getIsActive())
                .build();
    }

    public static BankAccountLengthRule toRuleEntity(BankDto dto) {
        if (dto == null || dto.getAccountLengthRule() == null) return null;

        return BankAccountLengthRule.builder()
                .id(dto.getAccountLengthRule().getId())
                .bankId(dto.getId())
                .minLen(dto.getAccountLengthRule().getMinLen())
                .maxLen(dto.getAccountLengthRule().getMaxLen())
                .build();
    }
}
