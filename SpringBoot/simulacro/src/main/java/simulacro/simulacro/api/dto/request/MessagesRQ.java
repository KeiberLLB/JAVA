package simulacro.simulacro.api.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesRQ {
  private String message_content;
  private Long receiver_id;
  private Long sender_id;
  private Long course_id;
  private LocalDateTime sent_date;
}
