package simulacro.simulacro.api.dto.response.basicResponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentsBasicResponse {
  private Long assignment_id;
  private String assignment_title;
  private String description;
  private LocalDateTime due_date;
}
