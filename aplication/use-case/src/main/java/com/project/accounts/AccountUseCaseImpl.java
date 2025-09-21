package com.project.accounts;

import com.project.account.AccountDto;

import com.project.account.gatewey.in.AccountUseCase;
import com.project.account.gatewey.out.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountUseCaseImpl implements AccountUseCase {

    private final AccountRepository accountRepository;

    @Override
    public Mono<AccountDto> createAccount(AccountDto accountDto) {
        accountDto.setCreatedAt(LocalDateTime.now());
        accountDto.setUpdatedAt(LocalDateTime.now());

        if (accountDto.getBankDto() == null) {
            return Mono.error(new IllegalArgumentException("El banco es obligatorio"));
        }
        if (accountDto.getAccountType() == null) {
            return Mono.error(new IllegalArgumentException("El tipo de cuenta es obligatorio"));
        }
        if (accountDto.getAlias() == null) {
            return Mono.error(new IllegalArgumentException("El alias es obligatorio"));
        }

        return accountRepository.save(accountDto);
    }

    @Override
    public Mono<AccountDto> updateAccount(Long id, AccountDto accountDto) {
        return accountRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cuenta no encontrada")))
                .flatMap(existing -> {
                    accountDto.setId(existing.getId());
                    accountDto.setCreatedAt(existing.getCreatedAt());
                    accountDto.setUpdatedAt(LocalDateTime.now());
                    return accountRepository.update(accountDto);
                });
    }

    @Override
    public Flux<AccountDto> getAllAccounts(Long bankId, String type) {
        return accountRepository.findAll(bankId, type);
    }

    @Override
    public Mono<Boolean> deleteAccount(Long id) {
        return accountRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cuenta no encontrada")))
                .flatMap(existing -> accountRepository.deleteById(id));
    }
}
