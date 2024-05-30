package simulacro.simulacro.api.dto.response.basicResponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionsRS {
  private Long submision_id;
  private String content;
  private LocalDateTime submission_date;
  private Double grade;
}
