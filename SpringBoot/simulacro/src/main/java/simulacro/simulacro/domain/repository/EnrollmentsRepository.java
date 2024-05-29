package simulacro.simulacro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simulacro.simulacro.domain.entities.Enrollments;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments,Long>{
  
}
