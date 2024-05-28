package simulacro.simulacro.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "assignments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long assignments_id;
  @Column(length = 100,nullable = false)
  private String assignment_title;
  @Lob
  private String description;
  @Column(nullable = false)
  private LocalDateTime due_date;
}
