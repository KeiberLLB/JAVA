package simulacro.simulacro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simulacro.simulacro.domain.entities.Assignments;

@Repository
public interface AssignmentsRepository extends JpaRepository<Assignments, Long>{
  
}
