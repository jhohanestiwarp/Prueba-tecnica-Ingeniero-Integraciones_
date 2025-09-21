package com.project.user.services;

import com.project.user.UserDto;
import com.project.user.UserUseCaseImp;
import com.project.user.gatewey.in.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserUseCaseImp userUseCaseImp;

    public Mono<UserDto> createClient(UserDto user) {
        return userUseCaseImp.createClient(user);
    }

    public Mono<UserDto> getClientByEmail(String email) {
        return userUseCaseImp.getClientByEmail(email);
    }
}
