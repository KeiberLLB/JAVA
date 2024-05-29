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
public class SubmissionsBasicResponse {
  private Long submision_id;
  private String content;
  private Double grade;
  private LocalDateTime submission_date;
}
