package simulacro.simulacro.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "enrollments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enrollments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long enrollment_id;
  @Column(nullable = false)
  private LocalDateTime enrollment_date;
}
