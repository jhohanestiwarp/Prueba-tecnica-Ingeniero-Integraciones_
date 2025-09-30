package com.project.student.config;

import com.project.user.UserMapper;
import com.project.user.UserRepositoryAdapter;
import com.project.user.UserUseCaseImp;
import com.project.user.gatewey.out.UserRepository;
import com.project.user.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UseCaseConfig {
    @Bean
    public UserMapper clientMapper(){
        return new UserMapper();
    }

    @Bean("clientServicePrimary")
    @Primary
    public UserService clientService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return new UserService(
                new UserUseCaseImp(userRepository, passwordEncoder)
        );
    }

    @Bean
    @Primary
    public UserRepository clientRepository(UserRepositoryAdapter userRepositoryAdapter){
        return userRepositoryAdapter;
    }

}
