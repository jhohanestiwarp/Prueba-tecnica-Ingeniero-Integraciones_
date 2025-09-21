package com.project.user.gatewey.out;

import com.project.user.UserDto;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<UserDto> save(UserDto user);
    Mono<UserDto> findById(Long id);
    Mono<UserDto> findByEmail(String email);
}
