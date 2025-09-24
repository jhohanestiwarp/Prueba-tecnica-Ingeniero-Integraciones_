package com.project.bankxaccounttype;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "banks_x_account_types")
public class BankAccountTypeData {

    @Id
    private Long id;

    @Column("bank_id")
    private Long bankId;

    @Column("account_type_id")
    private Long accountTypeId;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}
