package com.project.account;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AccountDataRepository extends ReactiveCrudRepository<AccountData, String> {

    Flux<AccountData> findAllByBankIdAndAccountTypeId(Long bankId, String type);

    Flux<AccountData> findAllByBankId(Long bankId);

    Flux<AccountData> findAllByAccountTypeId(String type);
}
