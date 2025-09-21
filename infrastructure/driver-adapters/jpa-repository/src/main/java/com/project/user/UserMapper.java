package com.project.user;

import reactor.core.publisher.Mono;

public class UserMapper {
    public final Mono<UserData> toEntityData(UserDto user) {
        return Mono.just(UserData.builder()
                .id(user.getId() != null ? user.getId() : null)
                .username(user.getUserName())
                .fullname(user.getFullName() != null ? user.getFullName() : null)
                .email(user.getEmail() != null ? user.getEmail() : null)
                .password(user.getPassword() != null ? user.getPassword() : null)
                .role(user.getRole() != null ? user.getRole() : null)
                .state(user.getState() != null ? user.getState() : null)
                .createdAt(user.getCreatedAt() != null ? user.getCreatedAt() : null)
                .updatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt() : null)
                .build());
    }

    public final Mono<UserData> toNewEntityData(UserDto user) {
        return Mono.just(UserData.builder()
                .username(user.getUserName())
                .fullname(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .state(user.getState())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build());
    }

    public final Mono<UserData> toUpdateEntityData(UserDto user) {
        return Mono.just(UserData.builder()
                .id(user.getId() != null ? user.getId() : null)
                .username(user.getUserName())
                .password(user.getPassword() != null ? user.getPassword() : null)
                .build());
    }

    public final UserDto toDomainModel(UserData userData) {
        return UserDto.builder()
                .id(userData.getId())
                .userName(userData.getUsername())
                .fullName(userData.getFullname())
                .email(userData.getEmail())
                .password(userData.getPassword())
                .role(userData.getRole())
                .state(userData.getState())
                .createdAt(userData.getCreatedAt())
                .updatedAt(userData.getUpdatedAt())
                .build();
    }
}
