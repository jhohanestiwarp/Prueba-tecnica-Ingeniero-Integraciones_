package com.project.account;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AccountDataRepository extends ReactiveCrudRepository<AccountData, String> {

    Flux<AccountData> findAllByBankAndType(String bank, String type);

    Flux<AccountData> findAllByBank(String bank);

    Flux<AccountData> findAllByType(String type);
}
