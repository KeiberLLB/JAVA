package simulacro.simulacro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simulacro.simulacro.domain.entities.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

}
