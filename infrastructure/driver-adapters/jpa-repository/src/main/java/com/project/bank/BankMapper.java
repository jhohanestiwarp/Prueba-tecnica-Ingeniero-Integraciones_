package com.project.bank;

import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    public BankData toEntityData(Bank bank) {
        return BankData.builder()
                .id(bank.getId())
                .code(bank.getCode())
                .nit(bank.getNit())
                .name(bank.getName())
                .isActive(bank.getIsActive())
                .createdAt(bank.getCreatedAt())
                .updatedAt(bank.getUpdatedAt())
                .build();
    }

    public BankData toEntityDataForUpdate(Bank bank, Bank existing) {
        return BankData.builder()
                .id(bank.getId())
                .code(bank.getCode())
                .nit(bank.getNit())
                .name(bank.getName())
                .isActive(bank.getIsActive())
                .createdAt(existing.getCreatedAt())
                .updatedAt(bank.getUpdatedAt())
                .build();
    }

    public Bank toDomainModel(BankData bankData) {
        if (bankData == null) {
            return null;
        }

        return Bank.builder()
                .id(bankData.getId())
                .code(bankData.getCode())
                .nit(bankData.getNit())
                .name(bankData.getName())
                .isActive(bankData.getIsActive())
                .createdAt(bankData.getCreatedAt())
                .updatedAt(bankData.getUpdatedAt())
                .build();
    }
}
