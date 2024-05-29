package simulacro.simulacro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simulacro.simulacro.domain.entities.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
  
}
