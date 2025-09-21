package com.project.bank;

import com.project.commons.properties.CreatedAt;
import com.project.commons.properties.Id;
import com.project.commons.properties.UpdatedAt;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    public BankData toEntityData(BankDto bankDto) {
        return BankData.builder()
                .id(bankDto.getId() != null ? bankDto.getId() : null)
                .nit(bankDto.getNit())
                .name(bankDto.getName())
                .createdAt(bankDto.getCreatedAt() != null ? bankDto.getCreatedAt() : null)
                .updatedAt(bankDto.getUpdatedAt() != null ? bankDto.getUpdatedAt() : null)
                .build();
    }

    public BankDto toDomainModel(BankData bankData) {
        if (bankData == null) {
            return null;
        }

        return BankDto.builder()
                .id(bankData.getId())
                .code(bankData.getCode())
                .nit(bankData.getNit())
                .name(bankData.getName())
                .isActive(bankData.getIsActive())
//                .accountLengthRule(bankData.getAccountLengthRuleId())
                .createdAt(bankData.getCreatedAt())
                .updatedAt(bankData.getUpdatedAt())
                .build();
    }
}
