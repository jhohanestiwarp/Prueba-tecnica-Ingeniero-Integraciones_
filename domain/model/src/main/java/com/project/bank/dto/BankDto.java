package com.project.bank.dto;

import com.project.accountypes.dto.AccountTypeDto;
import com.project.bankaccountlengthrule.dto.BankAccountLengthRuleDto;
import com.project.bankaccounttype.dto.BankAccountTypeDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Builder
public class BankDto {

    private Long id;
    private String code;
    private String nit;
    private String name;
    private Boolean isActive;
    private BankAccountLengthRuleDto accountLengthRule;
    private List<AccountTypeDto> accountTypes;
}
