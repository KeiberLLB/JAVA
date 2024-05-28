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
}
