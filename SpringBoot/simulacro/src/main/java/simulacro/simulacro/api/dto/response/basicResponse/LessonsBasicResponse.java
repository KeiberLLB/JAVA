package simulacro.simulacro.api.dto.response.basicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonsBasicResponse {
  private Long lesson_id;
  private String lesson_title;
  private String content;
}
