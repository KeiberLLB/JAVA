package simulacro.simulacro.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesBasicResponse;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesReceiverResponse {
  private Long message_id;
  private String message_content;
  private LocalDateTime sent_date;
  private Long sender_id;
  private Long receiver_id;
  private CoursesBasicResponse course;
}
