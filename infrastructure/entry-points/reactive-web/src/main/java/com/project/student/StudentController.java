package com.project.student;

import com.project.http.ResponseHandler;
import com.project.student.services.StudentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> create(
            @RequestBody Student request,
            @RequestHeader(name = "X-Channel", required = false) String channel) {
        return studentService.createStudent(request)
                .map(result -> ResponseHandler.success( "Estudiante creado exitosamente", result))
                .onErrorResume(e -> Mono.just(ResponseHandler.error(e.getMessage(), HttpStatus.BAD_REQUEST)));
    }


    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> getAll(
            @RequestParam(required = false) Long studentId,
            @RequestParam(required = false) String document,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email
    ) {
        logger.info("student: listing all students");

        return studentService.getAllStudents(studentId, document, firstName, lastName, email)
                .collectList()
                .map(list -> ResponseHandler.success("Estudiantes encontrados", list))
                .onErrorResume(e -> {
                    logger.error("Error al listar estudiantes: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> update(@PathVariable Long id, @RequestBody Student request) {
        logger.info("student: updating {}", id);

        return studentService.updateStudent(id, request)
                .map(updated -> ResponseHandler.success("Estudiante actualizado", updated))
                .switchIfEmpty(Mono.just(ResponseHandler.error("Estudiante no encontrado", HttpStatus.NOT_FOUND)))
                .onErrorResume(e -> {
                    logger.error("Error al actualizar estudiante: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> delete(@PathVariable Long id) {
        logger.info("student: deleting {}", id);

        return studentService.deleteStudent(id)
                .map(student -> ResponseHandler.success("Estudiante eliminado correctamente"))
                .switchIfEmpty(Mono.just(ResponseHandler.error("Estudiante no encontrado", HttpStatus.NOT_FOUND)))
                .onErrorResume(e -> {
                    logger.error("Error al eliminar estudiante: {}", e.getMessage());
                    return Mono.just(ResponseHandler.error("Error interno al eliminar", HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }
}
