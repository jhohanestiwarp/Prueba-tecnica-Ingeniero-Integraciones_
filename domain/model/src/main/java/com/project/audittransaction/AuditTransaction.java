package com.project.audittransaction;

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
public class AuditTransaction {
    private Long id;
    private String action;
    private String entity;
    private String entityId;
    private String channel;
    private String userId;
    private LocalDateTime createdAt;
}
