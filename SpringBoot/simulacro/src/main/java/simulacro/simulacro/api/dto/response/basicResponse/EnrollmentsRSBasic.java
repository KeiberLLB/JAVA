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
public class EnrollmentsRSBasic {
  private Long enrollment_id;
  private LocalDateTime enrollment_date;
}
