package com.project.bank;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "banks")
public class BankData {

    @Id
    private Long  id;
    private String nit;
    private String name;
    private String typesAllowed;
    private Integer minLength;
    private Integer maxLength;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
