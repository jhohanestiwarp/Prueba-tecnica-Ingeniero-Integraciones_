package com.project.bank;

import com.project.bankaccountlengthrule.BankAccountLengthRuleDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "banks")
public class BankData {

    @Id
    private Long id;

    @Column("code")
    private String code;

    @Column("nit")
    private String nit;

    @Column("name")
    private String name;

    @Column("is_active")
    private Boolean isActive;

    @Column("account_length_rule_id")
    private Long accountLengthRuleId;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}
