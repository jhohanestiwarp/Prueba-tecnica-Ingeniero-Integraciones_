package com.project.accountypes.dto;

import com.project.bankaccountlengthrule.dto.BankAccountLengthRuleDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class AccountTypeDto {
    private Long id;
    private String name;
    private String description;
    private Boolean isActive;
}
