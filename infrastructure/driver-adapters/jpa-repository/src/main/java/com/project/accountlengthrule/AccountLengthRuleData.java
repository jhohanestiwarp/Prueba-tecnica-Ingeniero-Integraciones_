package com.project.accountlengthrule;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "bank_account_length_rules")
public class AccountLengthRuleData {

    @Id
    private Long id;

    @Column("bank_id")
    private Long bankId;

    @Column("min_len")
    private Integer minLen;

    @Column("max_len")
    private Integer maxLen;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}
