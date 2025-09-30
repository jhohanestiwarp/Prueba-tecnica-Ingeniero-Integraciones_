package com.project.student.dto;

import com.project.user.UserDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class StudentDto {
    private Long id;
    private String fullName;
    private String document;
    private Integer age;
    private String email;
    private String cellPhone;
    private String state;
    private LocalDateTime createdAt;
}
