package com.project.bank;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDataRepository extends ReactiveCrudRepository<BankData, Long> {
}
