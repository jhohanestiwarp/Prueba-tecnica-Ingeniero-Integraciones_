package com.project.bankaccountlengthrule;

import com.project.bank.BankDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class BankAccountLengthRuleDTO {
    private Long id;
    private BankDto bank;
    private Integer minLen;
    private Integer maxLen;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
