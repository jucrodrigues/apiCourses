package br.com.juliana.apiCourses.modules.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Esse campo e obrigatorio")
    private String name;

    @NotBlank(message = "Esse campo e obrigatorio")
    private String category;

   @Enumerated(EnumType.STRING)
    private EnumCourseStatus status;

    @CreationTimestamp
    private LocalDateTime created_at;

    @CreationTimestamp
    private LocalDateTime updated_at;

}
