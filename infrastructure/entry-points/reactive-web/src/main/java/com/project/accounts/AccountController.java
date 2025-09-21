package com.project.accounts;

import com.project.account.AccountDto;
import com.project.account.gatewey.in.AccountUseCase;
import com.project.accounts.service.AccountService;
import com.project.http.ResponseHandler;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> create(@RequestBody AccountDto request) {
        logger.info("account: creating new account");

        return accountService.createAccount(request)
                .map(result -> ResponseHandler.success("Cuenta creada exitosamente", result))
                .onErrorResume(e -> {
                    logger.error("Error creando cuenta: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error(e.getMessage(), HttpStatus.BAD_REQUEST));
                });
    }

    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> getAll(
            @RequestParam(required = false) Long bankId,
            @RequestParam(required = false) String type
    ) {
        logger.info("account: listing all accounts");

        return accountService.getAllAccounts(bankId, type)
                .collectList()
                .map(list -> ResponseHandler.success("Cuentas encontradas", list))
                .onErrorResume(e -> {
                    logger.error("Error al listar cuentas: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> update(@PathVariable Long id, @RequestBody AccountDto request) {
        logger.info("account: updating {}", id);

        return accountService.updateAccount(id, request)
                .map(updated -> ResponseHandler.success("Cuenta actualizada", updated))
                .switchIfEmpty(Mono.just(ResponseHandler.error("Cuenta no encontrada", HttpStatus.NOT_FOUND)))
                .onErrorResume(e -> {
                    logger.error("Error al actualizar cuenta: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> delete(@PathVariable Long id) {
        logger.info("account: deleting {}", id);

        return accountService.deleteAccount(id)
                .map(deleted -> {
                    if (Boolean.TRUE.equals(deleted)) {
                        return ResponseHandler.success("Cuenta eliminada correctamente");
                    } else {
                        return ResponseHandler.error("Cuenta no encontrada", HttpStatus.NOT_FOUND);
                    }
                })
                .onErrorResume(e -> {
                    logger.error("Error al eliminar cuenta: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno al eliminar", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }
}
