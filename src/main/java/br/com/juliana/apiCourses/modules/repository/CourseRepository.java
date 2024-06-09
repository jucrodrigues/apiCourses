package br.com.juliana.apiCourses.modules.repository;

import br.com.juliana.apiCourses.modules.entity.CourseEntity;
import br.com.juliana.apiCourses.modules.entity.EnumCourseStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
  @Query("SELECT c FROM CourseEntity c WHERE c.name = :name")
  List<CourseEntity> findByName(String name);

  @Query("SELECT c FROM CourseEntity c WHERE c.category = :category")
  List<CourseEntity> findByCategory(String category);

CourseEntity findByStatus(EnumCourseStatus status);

}
