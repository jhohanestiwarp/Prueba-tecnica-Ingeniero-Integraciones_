package com.project.bankaccounttype.dto;

import com.project.account.AccountDto;
import com.project.accountypes.AccountType;
import com.project.bank.Bank;
import com.project.user.UserDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class BankAccountTypeDto {
    private Long id;
    private Long bankId;
    private Long accountTypeId;
}
