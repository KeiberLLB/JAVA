package simulacro.simulacro.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonsRQ {
  private String lesson_title;
  private String content;
  private Long course_id;
}
