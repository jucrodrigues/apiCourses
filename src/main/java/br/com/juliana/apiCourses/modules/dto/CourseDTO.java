package br.com.juliana.apiCourses.modules.dto;

import br.com.juliana.apiCourses.modules.entity.EnumCourseStatus;
import lombok.Data;

@Data
public class CourseDTO {

    private String name;
    private String category;
    private EnumCourseStatus status;

}
