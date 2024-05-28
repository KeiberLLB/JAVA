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

@Entity(name = "courses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long course_id;
  @Column(length = 100, nullable = false)
  private String course_name;
  @Lob
  private String description;
}
