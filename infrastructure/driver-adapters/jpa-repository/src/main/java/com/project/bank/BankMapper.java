package com.project.bank;

import com.project.bank.properties.*;
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
        return new BankDto(
                new Id(bankData.getId()),
                new BankId(bankData.getNit()),
                new BankName(bankData.getName()),
                new AccountTypesAllowed(bankData.getTypesAllowed()),
                new MinLength(bankData.getMinLength()),
                new MaxLength(bankData.getMaxLength()),
                new CreatedAt(bankData.getCreatedAt()),
                new UpdatedAt(bankData.getUpdatedAt())
        );
    }
}
