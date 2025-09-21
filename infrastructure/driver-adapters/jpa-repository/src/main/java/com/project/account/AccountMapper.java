package com.project.account;

import com.project.accountypes.AccountTypeDto;
import com.project.bank.BankDto;
import com.project.user.UserDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AccountMapper {

    public Mono<AccountData> toData(AccountDto dto) {
        return Mono.just(AccountData.builder()
                .id(dto.getId())
                .accountNumber(dto.getAccountNumber())
                .cellphone(dto.getCellphone())
                .alias(dto.getAlias())
                .typeDocument(dto.getTypeDocument())
                .document(dto.getDocument())
                .isInternalBank(dto.getIsInternalBank() != null ? dto.getIsInternalBank() : false)
                .status(dto.getStatus() != null ? dto.getStatus() : "ENROLLED")
                .userId(dto.getUser() != null ? dto.getUser().getId() : null)
                .bankId(dto.getBankDto() != null ? dto.getBankDto().getId() : null)
                .accountTypeId(dto.getAccountType() != null ? dto.getAccountType().getId() : null)
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build());
    }

    public AccountDto toDomain(AccountData data) {
        if (data == null) {
            return null;
        }

        return AccountDto.builder()
                .id(data.getId())
                .accountNumber(data.getAccountNumber())
                .cellphone(data.getCellphone())
                .alias(data.getAlias())
                .typeDocument(data.getTypeDocument())
                .document(data.getDocument())
                .isInternalBank(data.getIsInternalBank())
                .status(data.getStatus())
                .user(data.getUserId() != null
                        ? UserDto.builder().id(data.getUserId()).build()
                        : null)
                .bankDto(data.getBankId() != null
                        ? BankDto.builder().id(data.getBankId()).build()
                        : null)
                .accountType(data.getAccountTypeId() != null
                        ? AccountTypeDto.builder().id(data.getAccountTypeId()).build()
                        : null)
                .createdAt(data.getCreatedAt())
                .updatedAt(data.getUpdatedAt())
                .build();
    }
}
