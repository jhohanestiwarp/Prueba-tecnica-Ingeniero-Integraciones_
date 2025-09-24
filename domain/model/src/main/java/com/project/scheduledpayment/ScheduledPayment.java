package com.project.scheduledpayment;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class ScheduledPayment {
    private Long id;
    private Long userId;
    private Long originAccountId;
    private Long destinationAccountId;
    private Double amount;
    private LocalDateTime executeAt;
    private String status;
}
