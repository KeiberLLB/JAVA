package simulacro.simulacro.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursesRQ {
  private String course_name;
  private String description;
  private Long instructor_id;
}
