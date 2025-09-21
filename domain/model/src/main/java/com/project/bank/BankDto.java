package com.project.bank;

import com.project.bankaccountlengthrule.BankAccountLengthRuleDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class BankDto {

    private Long id;
    private String code;
    private String nit;
    private String name;
    private Boolean isActive;
    private BankAccountLengthRuleDTO accountLengthRule;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
