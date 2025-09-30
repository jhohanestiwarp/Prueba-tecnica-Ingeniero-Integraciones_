package com.project.student;

import com.project.commons.exception.EmailAlreadyExistsException;
import com.project.commons.exception.NotFoundException;
import com.project.student.dto.StudentDto;
import com.project.student.gatewey.in.StudentUseCase;
import com.project.student.gatewey.out.StudentRepository;
import com.project.translate.StudentToDtoTranslate;
import com.project.user.UserDto;
import com.project.user.gatewey.in.UserUseCase;
import com.project.user.gatewey.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudentUseCaseImp implements StudentUseCase {
    private final StudentRepository studentRepository;

    @Override
    public Mono<Student> createStudent(Student student) {
        if (student.getFirstName() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("FirstName")));
        }
        if (student.getLastName() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("LastName")));
        }
        if (student.getAge() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("Age")));
        }
        if (student.getDocumentType() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("DocumentType")));
        }
        if (student.getDocument() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("Document")));
        }
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setState("Active");
        return studentRepository.save(student);
    }

    @Override
    public Mono<Student> updateStudent(Long id, Student student) {
        if (student.getFirstName() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("FirstName")));
        }
        if (student.getLastName() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("LastName")));
        }
        if (student.getAge() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("Age")));
        }
        if (student.getDocumentType() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("DocumentType")));
        }
        if (student.getDocument() == null) {
            return Mono.error(new IllegalArgumentException(getErrorField("Document")));
        }
        student.setUpdatedAt(LocalDateTime.now());
        return studentRepository.findById(id)
                .flatMap(existing -> {
                    student.setId(existing.getId());
                    student.setCreatedAt(existing.getCreatedAt());
                    student.setUpdatedAt(LocalDateTime.now());
                    return studentRepository.update(student);
                });
    }

    @Override
    public Flux<StudentDto> getAllStudents(Long studentId, String document, String firstName, String lastName, String email) {
        return studentRepository.findAll(studentId, document, firstName, lastName, email)
                .map(StudentToDtoTranslate::toDto);
    }

    @Override
    public Mono<StudentDto> getById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(StudentToDtoTranslate::toDto);
    }

    @Override
    public Mono<Student> deleteStudent(Long id) {
        return studentRepository.findById(id)
                .flatMap(student -> {
                    student.setState("Deleted");
                    return studentRepository.update(student);
                });
    }

    private String getErrorField(String nameField){
        return "El campo " + nameField + " es obligatorio";
    }
}
