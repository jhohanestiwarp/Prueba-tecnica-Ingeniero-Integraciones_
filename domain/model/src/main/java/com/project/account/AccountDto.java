package com.project.account;

import com.project.accountypes.AccountTypeDto;
import com.project.bank.BankDto;
import com.project.user.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
    private BankDto bankDto;
    private AccountTypeDto accountType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
