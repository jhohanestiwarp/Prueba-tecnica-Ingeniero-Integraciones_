package com.project.bankaccounttype;

import com.project.accountypes.AccountType;
import com.project.bank.Bank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class BankAccountType {
    private Long id;
    private Long bankId;
    private Long accountTypeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
