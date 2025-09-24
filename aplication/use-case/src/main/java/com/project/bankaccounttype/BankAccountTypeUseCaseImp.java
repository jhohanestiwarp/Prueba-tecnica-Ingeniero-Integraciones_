package com.project.bankaccounttype;


import com.project.bankaccounttype.gatewey.in.BankAccountTypeUseCase;
import com.project.bankaccounttype.gatewey.out.BankAccountTypeRepository;
import com.project.translate.AccountTypeTranslate;
import com.project.translate.BankAccountTypeTranslate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BankAccountTypeUseCaseImp implements BankAccountTypeUseCase {

    private final BankAccountTypeRepository bankAccountTypeRepository;

    @Override
    public Mono<BankAccountType> createBankAccountType(BankAccountType bankAccountType) {

        bankAccountType.setCreatedAt(LocalDateTime.now());
        bankAccountType.setUpdatedAt(LocalDateTime.now());

        return bankAccountTypeRepository.save(bankAccountType);
    }

    @Override
    public Flux<BankAccountType> getAllBankAccountTypes() {
        return bankAccountTypeRepository.findAll();
    }

    @Override
    public Mono<Boolean> deleteBankAccountType(Long id) {
        return bankAccountTypeRepository.deleteById(id);
    }
}
