package simulacro.simulacro.api.dto.response.basicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursesBasicResponse {
  private Long course_id;
  private String course_name;
  private String description;
}
