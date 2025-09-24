package com.project.bankxaccounttype;

import com.project.accountypes.AccountType;
import com.project.bankaccounttype.BankAccountType;
import org.springframework.stereotype.Component;

@Component
public class BankAccountTypeMapper {

    public BankAccountTypeData toEntityData(BankAccountType bankAccountType, BankAccountType existing) {
        return BankAccountTypeData.builder()
                .id(bankAccountType.getId())
                .bankId(bankAccountType.getBankId())
                .accountTypeId(bankAccountType.getAccountTypeId())
                .createdAt(existing != null ? existing.getCreatedAt() : bankAccountType.getCreatedAt())
                .updatedAt(bankAccountType.getUpdatedAt())
                .build();
    }

    public BankAccountType toDomainModel(BankAccountTypeData bankAccountTypeData) {
        if (bankAccountTypeData == null) {
            return null;
        }

        return BankAccountType.builder()
                .id(bankAccountTypeData.getId())
                .bankId(bankAccountTypeData.getBankId())
                .accountTypeId(bankAccountTypeData.getAccountTypeId())
                .createdAt(bankAccountTypeData.getCreatedAt())
                .updatedAt(bankAccountTypeData.getUpdatedAt())
                .build();
    }
}
