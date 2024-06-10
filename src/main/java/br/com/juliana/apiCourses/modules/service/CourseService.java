package br.com.juliana.apiCourses.modules.service;

import br.com.juliana.apiCourses.exceptions.CourseFoundException;
import br.com.juliana.apiCourses.modules.entity.CourseEntity;
import br.com.juliana.apiCourses.modules.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity create(CourseEntity courseEntity) {
        return  this.courseRepository.save(courseEntity);
    }

    public List<CourseEntity> searchAll(){
        return this.courseRepository.findAll();
    }

    public CourseEntity searchById(UUID id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseFoundException());
    }

    public String searchByName(String name) {
        return ((CourseEntity) courseRepository.findByName(name)).getName();
    }

    public String searchByCategory(String category) {
        return ((CourseEntity) courseRepository.findByCategory(category)).getCategory();
    }

    public CourseEntity update (UUID id, Map<String, Object> params ) {
        CourseEntity course = courseRepository.findById(id)
                    .orElseThrow(() -> new CourseFoundException());
        
        if(params.containsKey("name")) {
            course.setName((String) params.get("name"));
        }
        if (params.containsKey("category")) {
            course.setCategory((String) params.get("category"));
        }  
        return courseRepository.save(course);          
    }

    public CourseEntity updateStatus(UUID id, boolean isActive) {
        CourseEntity course = courseRepository.findById(id)
                    .orElseThrow(() -> new CourseFoundException());
                    course.setActive(isActive);
        return courseRepository.save(course);            
    }

    public void delete(UUID id) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow(() -> new CourseFoundException());
        courseRepository.delete(courseEntity);
    }

}
