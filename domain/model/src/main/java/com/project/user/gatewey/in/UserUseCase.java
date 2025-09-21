package com.project.user.gatewey.in;

import com.project.user.UserDto;
import reactor.core.publisher.Mono;

public interface UserUseCase {
    Mono<UserDto> createClient(UserDto user);
    Mono<UserDto> getClientByEmail(String email);
}
