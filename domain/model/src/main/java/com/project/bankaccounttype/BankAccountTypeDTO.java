package com.project.bankaccounttype;

import com.project.accountypes.AccountTypeDto;
import com.project.bank.BankDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class BankAccountTypeDTO {
    private Long id;
    private BankDto bank;
    private AccountTypeDto accountType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
