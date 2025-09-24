package com.project.scheduledpayment;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "scheduled_payment")
public class ScheduledPaymentData {

    @Id
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("origin_account_id")
    private Long originAccountId;

    @Column("destination_account_id")
    private Long destinationAccountId;

    @Column("amount")
    private Double amount;

    @Column("execute_at")
    private LocalDateTime executeAt;

    @Column("status")
    private String status;
}
