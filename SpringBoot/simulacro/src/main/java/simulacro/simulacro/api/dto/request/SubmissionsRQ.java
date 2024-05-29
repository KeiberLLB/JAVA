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
public class SubmissionsRQ {
  private String content;
  private Long assignment_id;
  private Long student_id;
  private Double grade;
  private LocalDateTime submission_date;
}
