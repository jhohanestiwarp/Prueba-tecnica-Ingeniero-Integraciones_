package com.project.accounttype;

import com.project.accountypes.AccountType;
import com.project.bank.Bank;
import com.project.bankaccountlengthrule.BankAccountLengthRule;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeMapper {

    public AccountTypeData toEntityData(AccountType accountType, AccountType existing) {
        return AccountTypeData.builder()
                .id(accountType.getId())
                .name(accountType.getName())
                .description(accountType.getDescription())
                .isActive(accountType.getIsActive())
                .createdAt(existing != null ? existing.getCreatedAt() : accountType.getCreatedAt())
                .updatedAt(accountType.getUpdatedAt())
                .build();
    }

    public AccountType toDomainModel(AccountTypeData accountTypeData) {
        if (accountTypeData == null) {
            return null;
        }

        return AccountType.builder()
                .id(accountTypeData.getId())
                .name(accountTypeData.getName())
                .description(accountTypeData.getDescription())
                .isActive(accountTypeData.getIsActive())
                .createdAt(accountTypeData.getCreatedAt())
                .updatedAt(accountTypeData.getUpdatedAt())
                .build();
    }
}
