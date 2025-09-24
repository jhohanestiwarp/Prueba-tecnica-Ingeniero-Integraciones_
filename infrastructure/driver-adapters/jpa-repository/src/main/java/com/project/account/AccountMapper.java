package com.project.account;

import com.project.accountypes.AccountType;
import com.project.bank.Bank;
import com.project.user.UserDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AccountMapper {

    public Mono<AccountData> toData(Account dto) {
        return Mono.just(AccountData.builder()
                .id(dto.getId())
                .accountNumber(dto.getAccountNumber())
                .cellphone(dto.getCellphone())
                .alias(dto.getAlias())
                .typeDocument(dto.getTypeDocument())
                .document(dto.getDocument())
                .isInternalBank(dto.getIsInternalBank())
                .status(dto.getStatus())
                .userId(dto.getUserId())
                .bankId(dto.getBankId())
                .accountTypeId(dto.getAccountTypeId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build());
    }

    public Account toDomain(AccountData data) {
        if (data == null) {
            return null;
        }

        return Account.builder()
                .id(data.getId())
                .accountNumber(data.getAccountNumber())
                .cellphone(data.getCellphone())
                .alias(data.getAlias())
                .typeDocument(data.getTypeDocument())
                .document(data.getDocument())
                .isInternalBank(data.getIsInternalBank())
                .status(data.getStatus())
                .userId(data.getUserId())
                .bankId(data.getBankId())
                .accountTypeId(data.getAccountTypeId())
                .createdAt(data.getCreatedAt())
                .updatedAt(data.getUpdatedAt())
                .build();
    }
}
