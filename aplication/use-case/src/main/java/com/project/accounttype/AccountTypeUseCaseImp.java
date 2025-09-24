package com.project.accounttype;


import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.accountypes.gatewey.in.AccountTypeUseCase;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.translate.AccountTypeTranslate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountTypeUseCaseImp implements AccountTypeUseCase {

    private final AccountTypeRepository accountTypeRepository;

    @Override
    public Mono<AccountType> createAccountType(AccountType accountType) {

        accountType.setCreatedAt(LocalDateTime.now());
        accountType.setUpdatedAt(LocalDateTime.now());

        return accountTypeRepository.save(accountType);
    }

    @Override
    public Mono<AccountType> updateAccountType(Long id, AccountType accountType) {
        accountType.setUpdatedAt(LocalDateTime.now());
        return accountTypeRepository.findById(id)
                .flatMap(existing -> {
                    accountType.setId(existing.getId());
                    return accountTypeRepository.update(accountType, existing);
                });
    }

    @Override
    public Flux<AccountTypeDto> getAllAccountTypes() {
        return accountTypeRepository.findAll()
                .map(AccountTypeTranslate::toDto);
    }

    @Override
    public Mono<AccountTypeDto> findAccountTypeById(Long id) {
        return accountTypeRepository.findById(id)
                .map(AccountTypeTranslate::toDto);
    }

    @Override
    public Mono<Boolean> deleteAccountType(Long id) {
        return accountTypeRepository.deleteById(id);
    }
}
