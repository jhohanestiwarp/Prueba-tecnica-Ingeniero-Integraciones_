package com.project.scheduledPayment;


import com.project.account.gatewey.out.AccountRepository;
import com.project.accountypes.gatewey.out.AccountTypeRepository;
import com.project.bank.gatewey.out.BankRepository;
import com.project.bankaccounttype.BankAccountType;
import com.project.bankaccounttype.gatewey.in.BankAccountTypeUseCase;
import com.project.bankaccounttype.gatewey.out.BankAccountTypeRepository;
import com.project.scheduledpayment.ScheduledPayment;
import com.project.scheduledpayment.dto.ScheduledPaymentDto;
import com.project.scheduledpayment.gatewey.in.ScheduledPaymentUseCase;
import com.project.scheduledpayment.gatewey.out.ScheduledPaymentRepository;
import com.project.user.gatewey.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ScheduledPaymentUseCaseImp implements ScheduledPaymentUseCase {

    private final ScheduledPaymentRepository scheduledPaymentRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public Mono<ScheduledPayment> createScheduledPayment(ScheduledPayment scheduledPayment) {
        scheduledPayment.setStatus("SCHEDULED");
        return userRepository.findById(scheduledPayment.getUserId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Usuario no encontrado")))
                .flatMap(user ->
                        accountRepository.findById(scheduledPayment.getOriginAccountId())
                                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cuenta origen no encontrado")))
                                .flatMap(originAccount ->
                                        accountRepository.findById(scheduledPayment.getDestinationAccountId())
                                                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cuenta destino no encontrado")))
                                                .flatMap(destinationAccount ->
                                                        scheduledPaymentRepository.save(scheduledPayment)
                                                )
                                )
                );
    }

    @Override
    public Flux<ScheduledPayment> findScheduledPaymentByOriginAccountId(Long id) {
        return scheduledPaymentRepository.findByOriginAccountId(id);
    }

    @Override
    public Mono<Boolean> deleteScheduledPayment(Long id) {
        return scheduledPaymentRepository.deleteById(id);
    }
}
