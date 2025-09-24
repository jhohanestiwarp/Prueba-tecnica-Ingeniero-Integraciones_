package com.project.bankaccounttype;


import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.bank.gatewey.out.BankRepository;
import com.project.bankaccountlengthrule.gatewey.out.AccountLengthRuleRepository;
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

    private final BankRepository bankRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final BankAccountTypeRepository bankAccountTypeRepository;

    @Override
    public Mono<BankAccountType> createBankAccountType(BankAccountType bankAccountType) {
        bankAccountType.setCreatedAt(LocalDateTime.now());
        bankAccountType.setUpdatedAt(LocalDateTime.now());
        return bankRepository.findById(bankAccountType.getBankId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Banco no encontrado")))
                .flatMap(bank ->
                        accountTypeRepository.findById(bankAccountType.getAccountTypeId())
                                .switchIfEmpty(Mono.error(new IllegalArgumentException("Tipo de cuenta no encontrado")))
                                .flatMap(accountType ->
                                        bankAccountTypeRepository.save(bankAccountType)
                                )
                );
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
