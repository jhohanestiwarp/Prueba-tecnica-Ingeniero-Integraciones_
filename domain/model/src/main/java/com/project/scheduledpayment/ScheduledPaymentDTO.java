package com.project.scheduledpayment;

import com.project.account.AccountDto;
import com.project.user.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class ScheduledPaymentDTO {
    private Long id;
    private UserDto user;
    private AccountDto destinationAccount;
    private LocalDateTime executeAt;
    private String status;
}
