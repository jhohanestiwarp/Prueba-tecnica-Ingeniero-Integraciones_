package com.project.bank;


import com.project.bank.gatewey.in.BankUseCase;
import com.project.bank.gatewey.out.BankRepository;
import com.project.commons.properties.CreatedAt;
import com.project.commons.properties.UpdatedAt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BankUseCaseImp implements BankUseCase {

    private final BankRepository bankRepository;

    @Override
    public Mono<BankDto> createBank(BankDto bankDto) {

        bankDto.setCreatedAt(LocalDateTime.now());
        bankDto.setUpdatedAt(LocalDateTime.now());

        return bankRepository.save(bankDto);
    }

    @Override
    public Mono<BankDto> updateBank(Long id, BankDto bankDto) {
        return bankRepository.findById(id)
                .flatMap(existing -> {
                    bankDto.setId(existing.getId());
                    return bankRepository.update(bankDto);
                });
    }

    @Override
    public Flux<BankDto> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Mono<BankDto> findBankById(Long id) {
        return bankRepository.findById(id);
    }

    @Override
    public Mono<Boolean> deleteBank(Long id) {
        return bankRepository.deleteById(id);
    }
}
