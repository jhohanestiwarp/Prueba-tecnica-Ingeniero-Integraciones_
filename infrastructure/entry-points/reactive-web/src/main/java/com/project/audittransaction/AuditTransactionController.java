package com.project.audittransaction;

import com.project.accounttype.services.AccountTypeService;
import com.project.accountypes.AccountType;
import com.project.audittransaction.services.AuditTransactionService;
import com.project.http.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auditTransactions")
@RequiredArgsConstructor
public class AuditTransactionController {

    private final AuditTransactionService auditTransactionService;
    private static final Logger logger = LoggerFactory.getLogger(AuditTransactionController.class);

    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> getAll() {
        logger.info("bank: listing all banks");

        return auditTransactionService.getAllAccountTypes()
                .collectList()
                .map(list -> ResponseHandler.success("Bancos encontrados", list))
                .onErrorResume(e -> {
                    logger.error("Error al listar bancos: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }
}