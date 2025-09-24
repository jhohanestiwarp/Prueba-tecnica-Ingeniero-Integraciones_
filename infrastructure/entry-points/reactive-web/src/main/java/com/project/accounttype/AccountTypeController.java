package com.project.accounttype;

import com.project.accounts.service.AccountService;
import com.project.accounttype.services.AccountTypeService;
import com.project.accountypes.AccountType;
import com.project.bankaccountlengthrule.BankAccountLengthRule;
import com.project.bankaccountlengthrule.services.AccountLengthRuleService;
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
@RequestMapping("/api/v1/accountType")
@RequiredArgsConstructor
public class AccountTypeController {

    private final AccountTypeService accountTypeService;
    private static final Logger logger = LoggerFactory.getLogger(AccountTypeController.class);

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> create(@RequestBody AccountType request) {
        logger.info("bank: creating new bank");

        return accountTypeService.createAccountType(request)
                .map(result -> ResponseHandler.success("Banco creado exitosamente", result))
                .onErrorResume(e -> {
                    logger.error("Error creando banco: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error(e.getMessage(), HttpStatus.BAD_REQUEST));
                });
    }

    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> getAll() {
        logger.info("bank: listing all banks");

        return accountTypeService.getAllAccountTypes()
                .collectList()
                .map(list -> ResponseHandler.success("Bancos encontrados", list))
                .onErrorResume(e -> {
                    logger.error("Error al listar bancos: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> getById(@PathVariable Long id) {
        logger.info("rules: get by id {}", id);

        return accountTypeService.getById(id)
                .map(updated -> ResponseHandler.success("Banco actualizado", updated))
                .switchIfEmpty(Mono.just(ResponseHandler.error("Banco no encontrado", HttpStatus.NOT_FOUND)))
                .onErrorResume(e -> {
                    logger.error("Error al actualizar banco: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> update(@PathVariable Long id, @RequestBody AccountType request) {
        logger.info("bank: updating {}", id);

        return accountTypeService.updateAccountType(id, request)
                .map(updated -> ResponseHandler.success("Banco actualizado", updated))
                .switchIfEmpty(Mono.just(ResponseHandler.error("Banco no encontrado", HttpStatus.NOT_FOUND)))
                .onErrorResume(e -> {
                    logger.error("Error al actualizar banco: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> delete(@PathVariable Long id) {
        logger.info("bank: deleting {}", id);

        return accountTypeService.deleteAccountType(id)
                .map(deleted -> {
                    if (Boolean.TRUE.equals(deleted)) {
                        return ResponseHandler.success("Banco eliminado correctamente");
                    } else {
                        return ResponseHandler.error("Banco no encontrado", HttpStatus.NOT_FOUND);
                    }
                })
                .onErrorResume(e -> {
                    logger.error("Error al eliminar banco: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno al eliminar", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }
}