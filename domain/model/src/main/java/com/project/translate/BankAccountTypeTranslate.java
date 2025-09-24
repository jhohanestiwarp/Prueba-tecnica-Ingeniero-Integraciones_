package com.project.translate;

import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.bankaccounttype.BankAccountType;
import com.project.bankaccounttype.dto.BankAccountTypeDto;

public class BankAccountTypeTranslate {
    public static AccountTypeDto toDto(AccountType accountType) {
        if (accountType == null) return null;

        return AccountTypeDto.builder()
                .id(accountType.getId())
                .name(accountType.getName())
                .description(accountType.getDescription())
                .build();
    }
}
