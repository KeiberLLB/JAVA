package simulacro.simulacro.domain.entities;

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

@Entity(name = "lessons")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lessons {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long lesson_id;
  @Column(length = 100, nullable = false)
  private String lesson_title;
  @Lob
  private String conteString;
}
