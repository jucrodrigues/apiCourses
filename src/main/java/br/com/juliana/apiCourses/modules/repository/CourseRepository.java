package br.com.juliana.apiCourses.modules.repository;

import br.com.juliana.apiCourses.modules.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
  @Query("SELECT c FROM CourseEntity c WHERE c.name = :name")


  CourseEntity findCourseByName(String name);

  // CourseEntity findCourseByCategory(String category);

  // CourseEntity findByStatus(EnumCourseStatus status);

}
