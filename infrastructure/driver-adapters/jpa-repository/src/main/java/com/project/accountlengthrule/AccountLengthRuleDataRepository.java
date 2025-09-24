package com.project.accountlengthrule;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountLengthRuleDataRepository extends ReactiveCrudRepository<AccountLengthRuleData, Long> {
    Mono<AccountLengthRuleData> findFirstByBankId(Long bankId);
}
