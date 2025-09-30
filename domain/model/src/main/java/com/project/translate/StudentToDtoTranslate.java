package com.project.translate;

import com.project.student.Student;
import com.project.student.dto.StudentDto;
import com.project.user.UserDto;

public class StudentToDtoTranslate {
    public static StudentDto toDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .fullName(student.getFirstName().concat(" ").concat(student.getLastName()))
                .document(student.getDocumentType().concat(" ").concat(student.getDocument()))
                .age(student.getAge())
                .email(student.getEmail())
                .cellPhone(student.getCellPhone())
                .createdAt(student.getCreatedAt())
                .build();
    }
}
