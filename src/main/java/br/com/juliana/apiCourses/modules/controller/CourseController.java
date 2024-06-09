package br.com.juliana.apiCourses.modules.controller;

import br.com.juliana.apiCourses.modules.dto.CourseDTO;
import br.com.juliana.apiCourses.modules.entity.CourseEntity;
import br.com.juliana.apiCourses.modules.entity.EnumCourseStatus;
import br.com.juliana.apiCourses.modules.repository.CourseRepository;
import br.com.juliana.apiCourses.modules.service.CourseService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;


    @PostMapping("/")
    public CourseEntity created(@Valid @RequestBody CourseDTO createCourseDTO) {
        var course = CourseEntity.builder()
        .category(createCourseDTO.getCategory())
        .name(createCourseDTO.getName())
        .status(EnumCourseStatus.ACTIVE)
        .build();

        return this.courseService.create(course);
    }
    

    @GetMapping("/")
    public ResponseEntity<List<CourseEntity>> searchAll() {
        List<CourseEntity> courseEntities = courseService.searchAll();
        return ok(courseEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> searchById(@PathVariable UUID id) {
        CourseEntity course = courseService.searchById(id);
        if(course != null) {
            return ResponseEntity.ok().body(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<CourseEntity>> searchByName(@PathVariable String name) {
        List<CourseEntity> course = courseRepository.findByName(name);
        if(course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/{category}")
    public ResponseEntity<List<CourseEntity>> searchByCategory(@PathVariable String category){
        List<CourseEntity> course = courseRepository.findByCategory(category);
        if(course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
