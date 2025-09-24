package com.project.bankaccountlengthrule;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class BankAccountLengthRule {
    private Long id;
    private Long bankId;
    private Integer minLen;
    private Integer maxLen;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
