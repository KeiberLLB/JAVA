package simulacro.simulacro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simulacro.simulacro.domain.entities.Submissions;

@Repository
public interface SubmissionsRepository extends JpaRepository<Submissions,Long>{
  
}
