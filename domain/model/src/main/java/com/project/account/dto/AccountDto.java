package com.project.account.dto;

import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.bank.Bank;
import com.project.bank.dto.BankDto;
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
public class AccountDto {
    private Long id;
    private String accountNumber;
    private String cellphone;
    private String alias;
    private String typeDocument;
    private String document;
    private Boolean isInternalBank;
    private String status;
    private UserDto user;
    private BankDto bank;
    private AccountTypeDto accountType;
}
