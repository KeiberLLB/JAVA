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
public class AssignmentsRQ {
  private String assignment_title;
  private String description;
  private LocalDateTime due_date;
  private Long lesson_id;
}
