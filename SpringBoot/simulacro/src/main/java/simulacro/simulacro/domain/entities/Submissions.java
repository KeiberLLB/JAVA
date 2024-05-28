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

@Entity(name = "submissions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Submissions {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long submision_id;
  @Lob
  private String content;
  @Column(nullable = false)
  private LocalDateTime submission_date;
  @Column(nullable = false)
  private Double grade;

}
