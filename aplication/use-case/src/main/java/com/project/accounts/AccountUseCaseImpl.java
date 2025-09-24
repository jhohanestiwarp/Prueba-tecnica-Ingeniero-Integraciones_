package com.project.accounts;

import com.project.account.Account;

import com.project.account.gatewey.in.AccountUseCase;
import com.project.account.gatewey.out.AccountRepository;
import com.project.audittransaction.AuditTransaction;
import com.project.audittransaction.gatewey.out.AuditTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountUseCaseImpl implements AccountUseCase {

    private final AccountRepository accountRepository;
    private final AuditTransactionRepository auditTransactionRepository;

    private final static String CREATE = "CREATE";

    @Override
    public Mono<Account> createAccount(Account account, String username, String channel) {
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        account.setStatus("Active");

        if (account.getBankId() == null) {
            return auditOnError("El banco es obligatorio", account, username, CREATE, channel);
        }
        if (account.getAccountTypeId() == null) {
            return auditOnError("El tipo de cuenta es obligatorio", account, username, CREATE, channel);
        }
        if (account.getAlias() == null) {
            return auditOnError("El alias es obligatorio", account, username, CREATE, channel);
        }
        if (account.getUserId() == null) {
            return auditOnError("El Usuario es obligatorio", account, username, CREATE, channel);
        }

        return accountRepository.save(account)
                .flatMap(savedAccount -> {
                    AuditTransaction audit = AuditTransaction.builder()
                            .action("CREATE")
                            .entity("ACCOUNT")
                            .entityId(savedAccount.getId().toString())
                            .channel(channel)
                            .userId(username)
                            .createdAt(LocalDateTime.now())
                            .build();

                    return auditTransactionRepository.save(audit)
                            .thenReturn(savedAccount);
                })
                .onErrorResume(e -> {
                    AuditTransaction audit = AuditTransaction.builder()
                            .action("ERROR_CREATE")
                            .entity("ACCOUNT")
                            .entityId(account.getId() != null ? account.getId().toString() : "N/A")
                            .channel(channel)
                            .userId(username)
                            .createdAt(LocalDateTime.now())
                            .build();

                    return auditTransactionRepository.save(audit)
                            .then(Mono.error(e));
                });
    }

    @Override
    public Mono<Account> updateAccount(Long id, Account account) {
        return accountRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cuenta no encontrada")))
                .flatMap(existing -> {
                    account.setId(existing.getId());
                    account.setCreatedAt(existing.getCreatedAt());
                    account.setUpdatedAt(LocalDateTime.now());
                    return accountRepository.update(account);
                });
    }

    @Override
    public Flux<Account> getAllAccounts(Long bankId, String type) {
        return accountRepository.findAll(bankId, type);
    }

    @Override
    public Mono<Boolean> deleteAccount(Long id) {
        return accountRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cuenta no encontrada")))
                .flatMap(existing -> accountRepository.deleteById(id));
    }

    private Mono<Account> auditOnError(String message, Account account, String username, String typeError, String channel) {
        AuditTransaction audit = AuditTransaction.builder()
                .action("ERROR_" + typeError)
                .entity("ACCOUNT")
                .entityId(account.getId() != null ? account.getId().toString() : "N/A")
                .channel(channel)
                .userId(username)
                .createdAt(LocalDateTime.now())
                .build();

        return auditTransactionRepository.save(audit)
                .then(Mono.error(new IllegalArgumentException(message)));
    }
}
