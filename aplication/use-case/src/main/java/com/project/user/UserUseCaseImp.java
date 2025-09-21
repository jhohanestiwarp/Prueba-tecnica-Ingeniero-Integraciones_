package com.project.user;

import com.project.user.gatewey.in.UserUseCase;
import com.project.user.gatewey.out.UserRepository;
import com.project.commons.exception.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserUseCaseImp implements UserUseCase {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Mono<UserDto> createClient(UserDto user) {
        if (user.getUserName() == null) {
            return Mono.error(new IllegalArgumentException("El username es obligatorio"));
        }

        String encodePassword = encryptPassword(user.getPassword());
        user.setPassword(encodePassword);
        user.setState("Active");
        user.setRole("CLIENT");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.findByEmail(user.getEmail())
                .flatMap(existing -> Mono.<UserDto>error(new EmailAlreadyExistsException("El correo ya está registrado")))
                .switchIfEmpty(userRepository.save(user));
    }

    @Override
    public Mono<UserDto> getClientByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
