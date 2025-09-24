package com.project.account;

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
public class Account {
    private Long id;
    private String accountNumber;
    private String cellphone;
    private String alias;
    private String typeDocument;
    private String document;
    private Boolean isInternalBank;
    private String status;
    private Long userId;
    private Long bankId;
    private Long accountTypeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
