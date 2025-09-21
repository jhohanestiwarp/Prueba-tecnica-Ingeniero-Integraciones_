package com.project.user;

import com.project.user.services.UserService;
import com.project.commons.exception.EmailAlreadyExistsException;
import com.project.http.ResponseHandler;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserMapper mapper;
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public Mono<ResponseEntity<?>> createUser(@RequestBody UserDto user) {
        logger.info("UserDto: creating new user");

        return userService.createClient(user)
                .flatMap(result -> {
                    if (result == null) {
                        return Mono.just(ResponseHandler.success("Can't register user"));
                    } else {
                        return mapper.toEntityData(result)
                                .map(entityData -> ResponseEntity
                                        .status(HttpStatus.CREATED)
                                        .body(ResponseHandler.success("Success", entityData)));
                    }
                })
                .onErrorResume(EmailAlreadyExistsException.class, e -> {
                    logger.info("Email duplicado: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error(e.getMessage(), HttpStatus.CONFLICT));
                })
                .onErrorResume(IllegalArgumentException.class, e -> {
                    logger.info(e.getMessage());
                    return Mono.just(ResponseHandler.error(e.getMessage()));
                })
                .onErrorResume(Exception.class, e -> {
                    logger.error("Internal error", e);
                    return Mono.just(ResponseHandler.error("Internal server error"));
                });
    }

    @GetMapping
    public Mono<ResponseEntity<?>> getUserByEmail() {
        return ReactiveSecurityContextHolder.getContext()
                .flatMap(context -> {
                    String email = context.getAuthentication().getName();
                    logger.info("Getting user by email: {}", email);
                    return userService.getClientByEmail(email)
                            .flatMap(result -> {
                                if (result == null) {
                                    return Mono.just(ResponseHandler.success("UserDto not found"));
                                } else {
                                    return mapper.toEntityData(result)
                                            .map(data -> ResponseEntity.ok(ResponseHandler.success("Success", data)));
                                }
                            });
                })
                .onErrorResume(Exception.class, e -> {
                    logger.error("Error:", e);
                    return Mono.just(ResponseHandler.error("Internal server error"));
                });
    }
}