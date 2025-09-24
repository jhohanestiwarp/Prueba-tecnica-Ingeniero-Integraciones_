package com.project.bank;


import com.project.accountypes.AccountType;
import com.project.accountypes.dto.AccountTypeDto;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.bank.dto.BankDto;
import com.project.bank.gatewey.in.BankUseCase;
import com.project.bank.gatewey.out.BankRepository;
import com.project.bankaccountlengthrule.BankAccountLengthRule;
import com.project.bankaccountlengthrule.gatewey.out.AccountLengthRuleRepository;
import com.project.bankaccounttype.BankAccountType;
import com.project.bankaccounttype.dto.BankAccountTypeDto;
import com.project.bankaccounttype.gatewey.out.BankAccountTypeRepository;
import com.project.translate.AccountLengthTranslate;
import com.project.translate.AccountTypeTranslate;
import com.project.translate.BankAccountTypeTranslate;
import com.project.translate.BankAndAccountLengthTranslate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankUseCaseImp implements BankUseCase {

    private final BankRepository bankRepository;
    private final AccountLengthRuleRepository accountLengthRuleRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final BankAccountTypeRepository bankAccountTypeRepository;

    @Override
    public Mono<Bank> createBank(Bank bank) {
        bank.setIsActive(true);
        bank.setCreatedAt(LocalDateTime.now());
        bank.setUpdatedAt(LocalDateTime.now());

        return bankRepository.save(bank);
    }

    @Override
    public Mono<Bank> updateBank(Long id, Bank bank) {
        bank.setUpdatedAt(LocalDateTime.now());
        return bankRepository.findById(id)
                .flatMap(existing -> {
                    bank.setId(existing.getId());
                    return bankRepository.update(bank, existing);
                });
    }

    @Override
    public Flux<BankDto> getAllBanks() {
        return bankRepository.findAll()
                .flatMap(bank -> {
                    Mono<BankAccountLengthRule> ruleMono =
                            accountLengthRuleRepository.findByBankId(bank.getId());
                    Mono<List<AccountTypeDto>> accountTypesMono =
                            bankAccountTypeRepository.findByBankId(bank.getId())
                                    .flatMap(bankAccountType ->
                                            accountTypeRepository.findById(bankAccountType.getAccountTypeId())
                                                    .map(AccountTypeTranslate::toDto)
                                    )
                                    .collectList();
                    return Mono.zip(ruleMono, accountTypesMono)
                            .map(tuple -> {
                                BankAccountLengthRule rule = tuple.getT1();
                                List<AccountTypeDto> accountTypes = tuple.getT2();
                                return BankAndAccountLengthTranslate.toDto(
                                        bank,
                                        AccountLengthTranslate.toDto(rule),
                                        accountTypes
                                );
                            });
                });
    }

    @Override
    public Mono<BankDto> findBankById(Long id) {
        Mono<Bank> bankMono = bankRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Banco no encontrado")));
        Mono<BankAccountLengthRule> ruleMono =
                accountLengthRuleRepository.findByBankId(id);
        Mono<List<AccountTypeDto>> accountTypesMono =
                bankAccountTypeRepository.findByBankId(id)
                        .flatMap(bankAccountType ->
                                accountTypeRepository.findById(bankAccountType.getAccountTypeId())
                                        .map(AccountTypeTranslate::toDto)
                        )
                        .collectList();
        return Mono.zip(ruleMono, accountTypesMono, bankMono)
                .map(tuple -> {
                    BankAccountLengthRule rule = tuple.getT1();
                    List<AccountTypeDto> accountTypes = tuple.getT2();
                    Bank bank = tuple.getT3();

                    return BankAndAccountLengthTranslate.toDto(
                            bank,
                            AccountLengthTranslate.toDto(rule),
                            accountTypes
                    );
                });
    }

    @Override
    public Mono<Boolean> deleteBank(Long id) {
        return bankRepository.deleteById(id);
    }
}
