package com.project.user;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserDataRepository extends ReactiveCrudRepository<UserData, Long> {
    @Query("SELECT * FROM users WHERE email = :email")
    Mono<UserData> findByEmail(String email);
}

