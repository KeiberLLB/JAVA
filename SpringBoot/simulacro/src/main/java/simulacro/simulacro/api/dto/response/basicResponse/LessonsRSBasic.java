package simulacro.simulacro.api.dto.response.basicResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LessonsRSBasic {
  private Long lesson_id;
  private String lesson_title;
  private String content;
}
