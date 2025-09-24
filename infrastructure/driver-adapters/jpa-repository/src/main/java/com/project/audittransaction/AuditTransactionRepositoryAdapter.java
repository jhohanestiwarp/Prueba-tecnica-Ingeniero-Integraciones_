package com.project.audittransaction;

import com.project.accountypes.AccountType;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.audittransaction.gatewey.out.AuditTransactionRepository;
import com.project.user.gatewey.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuditTransactionRepositoryAdapter implements AuditTransactionRepository {

    private final AuditTransactionDataRepository repository;
    private final AuditTransactionMapper mapper;
    private final UserRepository userRepository;

    @Override
    public Mono<AuditTransaction> save(AuditTransaction auditTransaction) {
        return userRepository.findByEmail(auditTransaction.getUserId())
                .flatMap(userDto -> {
                    auditTransaction.setUserId(userDto.getId().toString());
                    return repository.save(mapper.toEntityData(auditTransaction))
                            .map(mapper::toDomainModel);
                });
    }

    @Override
    public Flux<AuditTransaction> findAll() {
        return repository.findAll().map(mapper::toDomainModel);
    }

}