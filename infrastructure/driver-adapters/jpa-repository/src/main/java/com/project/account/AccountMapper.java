package com.project.account;

import com.project.account.properties.*;
import com.project.commons.properties.CreatedAt;
import com.project.commons.properties.Id;
import com.project.commons.properties.UpdatedAt;
import com.project.user.UserDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AccountMapper {

    public Mono<AccountData> toData(AccountDto accountDto) {
        return Mono.just(AccountData.builder()
                .id(accountDto.getId() != null ? accountDto.getId().getValue() : null)
                .bank(accountDto.getBankDto() != null ? accountDto.getBankDto().getValue() : null)
                .type(accountDto.getType() != null ? accountDto.getType().getValue() : null)
                .number(accountDto.getNumber() != null ? accountDto.getNumber().getValue() : null)
                .alias(accountDto.getAlias() != null ? accountDto.getAlias().getValue() : null)
                .cellphone(accountDto.getCellphone() != null ? accountDto.getCellphone().getValue() : null)
                .state(accountDto.getState() != null ? accountDto.getState().getValue() : null)
                .userId(accountDto.getUser() != null ? accountDto.getUser().getId().getValue() : null)
                .createdAt(accountDto.getCreatedAt() != null ? accountDto.getCreatedAt().getValue() : null)
                .updatedAt(accountDto.getUpdatedAt() != null ? accountDto.getUpdatedAt().getValue() : null)
                .build());
    }

    public AccountDto toDomain(AccountData data) {
        return new AccountDto(
                data.getId() != null ? new Id(data.getId()) : null,
                data.getBank() != null ? new Bank(data.getBank()) : null,
                data.getType() != null ? new AccountType(data.getType()) : null,
                data.getNumber() != null ? new AccountNumber(data.getNumber()) : null,
                data.getAlias() != null ? new Alias(data.getAlias()) : null,
                data.getCellphone() != null ? new Cellphone(data.getCellphone()) : null,
                data.getState() != null ? new AccountState(data.getState()) : null,
                data.getUserId() != null ? new UserDto(new Id(data.getUserId()), null, null, null, null, null, null, null, null) : null,
                data.getCreatedAt() != null ? new CreatedAt(data.getCreatedAt()) : null,
                data.getUpdatedAt() != null ? new UpdatedAt(data.getUpdatedAt()) : null
        );
    }
}
