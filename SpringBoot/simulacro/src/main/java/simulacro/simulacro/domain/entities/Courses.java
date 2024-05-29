package simulacro.simulacro.domain.entities;

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "instructor_id", referencedColumnName = "user_id")
  private Users instructor;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Enrollments> enrollments;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Messages> messages;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Lessons> lessons;

}
