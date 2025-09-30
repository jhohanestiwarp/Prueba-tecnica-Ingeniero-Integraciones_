package com.project.student;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String documentType;
    private String document;
    private Integer age;
    private String email;
    private String cellPhone;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
