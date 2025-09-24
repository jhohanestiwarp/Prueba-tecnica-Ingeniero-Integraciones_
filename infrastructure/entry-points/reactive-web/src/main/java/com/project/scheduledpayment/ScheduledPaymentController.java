package com.project.scheduledpayment;

import com.project.accounttype.services.AccountTypeService;
import com.project.accountypes.AccountType;
import com.project.http.ResponseHandler;
import com.project.scheduledPayment.services.ScheduledPaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/scheduledPayment")
@RequiredArgsConstructor
public class ScheduledPaymentController {

    private final ScheduledPaymentService scheduledPaymentService;
    private static final Logger logger = LoggerFactory.getLogger(ScheduledPaymentController.class);

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> create(@RequestBody ScheduledPayment request) {
        logger.info("bank: creating new bank");

        return scheduledPaymentService.createScheduledPayment(request)
                .map(result -> ResponseHandler.success("Banco creado exitosamente", result))
                .onErrorResume(e -> {
                    logger.error("Error creando banco: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error(e.getMessage(), HttpStatus.BAD_REQUEST));
                });
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> getById(@PathVariable Long id) {
        logger.info("rules: get by id {}", id);

        return scheduledPaymentService.getAllScheduledPayments(id)
                .collectList()
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

        return scheduledPaymentService.deleteScheduledPayment(id)
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