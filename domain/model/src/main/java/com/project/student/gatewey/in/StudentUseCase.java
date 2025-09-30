package com.project.student.gatewey.in;

import com.project.student.Student;
import com.project.student.dto.StudentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentUseCase {
    Mono<Student> createStudent(Student student);

    Mono<Student> updateStudent(Long id, Student student);

    Flux<StudentDto> getAllStudents(Long studentId, String document, String firstName, String lastName, String email);

    Mono<StudentDto> getById(Long studentId);

    Mono<Student> deleteStudent(Long id);
}
