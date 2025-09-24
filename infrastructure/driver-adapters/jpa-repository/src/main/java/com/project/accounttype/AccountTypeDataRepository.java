package com.project.accounttype;

import com.project.account.AccountData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AccountTypeDataRepository extends ReactiveCrudRepository<AccountTypeData, Long> {
}
