package com.project.scheduledpayment;

import com.project.accountypes.AccountType;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPaymentMapper {

    public ScheduledPaymentData toEntityData(ScheduledPayment scheduledPayment) {
        return ScheduledPaymentData.builder()
                .id(scheduledPayment.getId())
                .userId(scheduledPayment.getUserId())
                .originAccountId(scheduledPayment.getOriginAccountId())
                .destinationAccountId(scheduledPayment.getDestinationAccountId())
                .amount(scheduledPayment.getAmount())
                .status(scheduledPayment.getStatus())
                .executeAt(scheduledPayment.getExecuteAt())
                .build();
    }

    public ScheduledPayment toDomainModel(ScheduledPaymentData scheduledPaymentData) {
        if (scheduledPaymentData == null) {
            return null;
        }

        return ScheduledPayment.builder()
                .id(scheduledPaymentData.getId())
                .userId(scheduledPaymentData.getUserId())
                .originAccountId(scheduledPaymentData.getOriginAccountId())
                .destinationAccountId(scheduledPaymentData.getDestinationAccountId())
                .amount(scheduledPaymentData.getAmount())
                .executeAt(scheduledPaymentData.getExecuteAt())
                .status(scheduledPaymentData.getStatus())
                .build();
    }
}
