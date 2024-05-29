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
public class EnrollmentsRQ {
  private LocalDateTime enrollment_date;
  private Long user_id;
  private Long course_id;
}
