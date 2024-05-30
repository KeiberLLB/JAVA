package simulacro.simulacro.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private Users student;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id", referencedColumnName = "course_id")
  private Courses course;

}
