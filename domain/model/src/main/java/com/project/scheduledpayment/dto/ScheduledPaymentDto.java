package com.project.scheduledpayment.dto;

import com.project.account.Account;
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
public class ScheduledPaymentDto {
    private Long id;
    private UserDto user;
    private Account originAccount;
    private Account destinationAccount;
    private Double amount;
    private LocalDateTime executeAt;
    private String status;
}
