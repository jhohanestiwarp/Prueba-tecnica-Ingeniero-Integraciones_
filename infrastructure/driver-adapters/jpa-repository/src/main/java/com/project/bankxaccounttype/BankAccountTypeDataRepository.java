package com.project.bankxaccounttype;

import com.project.account.AccountData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BankAccountTypeDataRepository extends ReactiveCrudRepository<BankAccountTypeData, Long> {
    Flux<BankAccountTypeData> findAllByBankId(Long bankId);
}
