package com.project.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentDataRepository extends ReactiveCrudRepository<StudentData, String> {

    Flux<StudentData> findAllById(Long studentId);
    Flux<StudentData> findAllByDocument(String document);
    Flux<StudentData> findAllByFirstName(String firstName);
    Flux<StudentData> findAllByLastName(String lastName);
    Flux<StudentData> findAllByEmail(String email);
}
