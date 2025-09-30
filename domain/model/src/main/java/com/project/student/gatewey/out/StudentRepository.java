package com.project.student.gatewey.out;

import com.project.student.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository {
    Mono<Student> save(Student student);

    Mono<Student> update(Student student);

    Flux<Student> findAll(Long studentId, String document, String firstName, String lastName, String email);

    Mono<Student> findById(Long id);

    Mono<Boolean> deleteById(Long id);
}

