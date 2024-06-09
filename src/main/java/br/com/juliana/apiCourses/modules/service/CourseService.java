package br.com.juliana.apiCourses.modules.service;

import br.com.juliana.apiCourses.exceptions.CourseFoundException;
import br.com.juliana.apiCourses.modules.entity.CourseEntity;
import br.com.juliana.apiCourses.modules.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return courseRepository.findCourseByName(name).getName();
    }

  


    public void delete(UUID id) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow(() -> new CourseFoundException());
        courseRepository.delete(courseEntity);
    }

}
