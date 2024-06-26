package simulacro.simulacro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simulacro.simulacro.domain.entities.Lessons;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons, Long> {
  
}
