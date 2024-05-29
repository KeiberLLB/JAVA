package simulacro.simulacro.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "messages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Messages {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long message_id;
  @Lob
  private String message_content;
  @Column(nullable = false)
  private LocalDateTime sent_date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "receiver_id", referencedColumnName = "user_id")
  private Users receiver;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
  private Users sender;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id", referencedColumnName = "course_id")
  private Courses course;
}
