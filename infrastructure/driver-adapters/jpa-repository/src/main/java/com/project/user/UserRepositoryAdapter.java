package com.project.user;

import com.project.user.gatewey.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserMapper mapper;
    private final UserDataRepository repository;
    @Override
    public Mono<UserDto> save(UserDto user) {
        return Mono.just(user)
                .flatMap(mapper::toNewEntityData)
                .flatMap(repository::save)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<UserDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomainModel);
    }

    @Override
    public Mono<UserDto> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::toDomainModel);
    }
}
