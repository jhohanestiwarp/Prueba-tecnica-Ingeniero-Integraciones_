package com.project.audittransaction;


import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.audittransaction.dto.AuditTransactionDto;
import com.project.audittransaction.gatewey.in.AuditTransactionUseCase;
import com.project.audittransaction.gatewey.out.AuditTransactionRepository;
import com.project.translate.AccountTypeTranslate;
import com.project.translate.AuditTransactionTranslate;
import com.project.user.gatewey.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditTransactionUseCaseImp implements AuditTransactionUseCase {

    private final AuditTransactionRepository auditTransactionRepository;
    private final UserRepository userRepository;

    @Override
    public Mono<AuditTransaction> save(AuditTransaction auditTransaction) {

        return auditTransactionRepository.save(auditTransaction);
    }

    @Override
    public Flux<AuditTransactionDto> getAllAuditTransactions() {
        return auditTransactionRepository.findAll()
                .flatMap(auditTransaction ->
                    userRepository.findById(Long.valueOf(auditTransaction.getUserId()))
                            .map(user -> AuditTransactionTranslate.toDto(auditTransaction, user))
                );
    }
}
