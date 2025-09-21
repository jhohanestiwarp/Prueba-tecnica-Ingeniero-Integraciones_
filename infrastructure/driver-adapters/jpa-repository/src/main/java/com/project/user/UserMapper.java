package com.project.user;

import com.project.user.properties.Email;
import com.project.user.properties.FullName;
import com.project.user.properties.Password;
import com.project.user.properties.Role;
import com.project.commons.properties.CreatedAt;
import com.project.commons.properties.Id;
import com.project.commons.properties.State;
import com.project.commons.properties.UpdatedAt;
import reactor.core.publisher.Mono;

public class UserMapper {
    public final Mono<UserData> toEntityData(UserDto user) {
        return Mono.just(UserData.builder()
                .id(user.getId() != null ? user.getId() : null)
                .username(user.getUserName())
                .fullName(user.getFullName() != null ? user.getFullName() : null)
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
                .fullName(user.getFullName() != null ? user.getFullName() : null)
                .email(user.getEmail() != null ? user.getEmail() : null)
                .password(user.getPassword() != null ? user.getPassword() : null)
                .role(user.getRole() != null ? user.getRole() : null)
                .state(user.getState() != null ? user.getState() : null)
                .createdAt(user.getCreatedAt() != null ? user.getCreatedAt() : null)
                .updatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt() : null)
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
                .fullName(userData.getFullName())
                .email(userData.getEmail())
                .password(userData.getPassword())
                .role(userData.getRole())
                .state(userData.getState())
                .createdAt(userData.getCreatedAt())
                .updatedAt(userData.getUpdatedAt())
                .build();
    }
}
