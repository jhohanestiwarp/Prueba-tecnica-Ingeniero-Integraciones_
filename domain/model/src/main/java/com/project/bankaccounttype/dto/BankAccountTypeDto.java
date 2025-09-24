package com.project.bankaccounttype.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class BankAccountTypeDto {
    private Long id;
    private Long bankId;
    private Long accountTypeId;
}
