package com.project.audittransaction;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "audit_td.audit_transaction")
public class AuditTransactionData {
    @Id
    private Long id;

    @Column("action")
    private String action;

    @Column("entity")
    private String entity;

    @Column("entity_id")
    private String entityId;

    @Column("channel")
    private String channel;

    @Column("user_id")
    private String userId;

    @Column("created_at")
    private LocalDateTime createdAt;
}
