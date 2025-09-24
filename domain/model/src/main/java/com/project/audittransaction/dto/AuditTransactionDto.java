package com.project.audittransaction.dto;

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
public class AuditTransactionDto {
    private Long id;
    private String action;
    private String entity;
    private String entityId;
    private String channel;
    private UserDto user;
    private LocalDateTime createdAt;
}
