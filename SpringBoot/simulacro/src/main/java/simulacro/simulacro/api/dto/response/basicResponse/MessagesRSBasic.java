package simulacro.simulacro.api.dto.response.basicResponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesRSBasic {
  private Long message_id;
  private String message_content;
  private LocalDateTime sent_date;
}
