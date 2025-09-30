package com.project.student;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class StudentMapper {

    public Mono<StudentData> toData(Student student) {
        return Mono.just(StudentData.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .documentType(student.getDocumentType())
                .document(student.getDocument())
                .age(student.getAge())
                .email(student.getEmail())
                .cellPhone(student.getCellPhone())
                .createdAt(student.getCreatedAt())
                .updatedAt(student.getUpdatedAt())
                .build());
    }

    public Student toDomain(StudentData data) {
        if (data == null) {
            return null;
        }

        return Student.builder()
                .id(data.getId())
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .documentType(data.getDocumentType())
                .document(data.getDocument())
                .age(data.getAge())
                .email(data.getEmail())
                .cellPhone(data.getCellPhone())
                .createdAt(data.getCreatedAt())
                .updatedAt(data.getUpdatedAt())
                .build();
    }
}
