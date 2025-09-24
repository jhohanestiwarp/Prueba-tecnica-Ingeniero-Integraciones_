package com.project.bankaccountlengthrule.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class BankAccountLengthRuleDto {
    private Long id;
    private Long bankId;
    private Integer minLen;
    private Integer maxLen;
}
