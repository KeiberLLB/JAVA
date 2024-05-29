package simulacro.simulacro.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "assignments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long assignment_id;
  @Column(length = 100, nullable = false)
  private String assignment_title;
  @Lob
  private String description;
  @Column(nullable = false)
  private LocalDateTime due_date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
  private Lessons lesson;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "assignment", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Submissions> submissions;

}
