package com.project.student;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "students")
public class StudentData {

    @Id
    private Long id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("document_type")
    private String documentType;

    @Column("document")
    private String document;

    @Column("age")
    private Integer age;

    @Column("email")
    private String email;

    @Column("cell_phone")
    private String cellPhone;

    @Column("state")
    private String state;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}