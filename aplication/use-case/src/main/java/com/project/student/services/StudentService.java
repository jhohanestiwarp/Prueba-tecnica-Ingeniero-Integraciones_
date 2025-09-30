package com.project.student.services;

import com.project.student.Student;
import com.project.student.StudentUseCaseImp;
import com.project.student.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentUseCaseImp studentUseCaseImp;

    public Mono<Student> createStudent(Student student) {
        return studentUseCaseImp.createStudent(student);
    }

    public Mono<Student> updateStudent(Long id, Student student) {
        return studentUseCaseImp.updateStudent(id, student);
    }

    public Flux<StudentDto> getAllStudents(Long studentId, String document, String firstName, String lastName, String email) {
        return studentUseCaseImp.getAllStudents(studentId, document, firstName, lastName, email);
    }

    public Mono<StudentDto> getById(Long studentId) {
        return studentUseCaseImp.getById(studentId);
    }

    public Mono<Student> deleteStudent(Long id) {
        return studentUseCaseImp.deleteStudent(id);
    }
}
