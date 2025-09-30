package com.project.student;

import com.project.student.gatewey.out.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StudentRepositoryAdapter implements StudentRepository {

    private final StudentDataRepository repository;
    private final StudentMapper mapper;

    @Override
    public Mono<Student> save(Student student) {
        return mapper.toData(student)
                .flatMap(repository::save)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Student> update(Student student) {
        return mapper.toData(student)
                .flatMap(repository::save)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Student> findAll(Long studentId, String document, String firstName, String lastName, String email) {
        if (studentId != null) {
            return repository.findAllById(studentId)
                    .map(mapper::toDomain);
        } else if (document != null && !document.isBlank()) {
            return repository.findAllByDocument(document)
                    .map(mapper::toDomain);
        }else if (firstName != null && !firstName.isBlank()) {
            return repository.findAllByFirstName(firstName)
                    .map(mapper::toDomain);
        }else if (lastName != null && !lastName.isBlank()) {
            return repository.findAllByLastName(lastName)
                    .map(mapper::toDomain);
        }else if (email != null && !email.isBlank()) {
            return repository.findAllByEmail(email)
                    .map(mapper::toDomain);
        } else {
            return repository.findAll()
                    .map(mapper::toDomain)
                    .filter(Objects::nonNull);
        }
    }

    @Override
    public Mono<Student> findById(Long id) {
        return repository.findById(id.toString())
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.findById(id.toString())
                .flatMap(account -> repository.deleteById(id.toString()).thenReturn(true))
                .switchIfEmpty(Mono.just(false));
    }
}
