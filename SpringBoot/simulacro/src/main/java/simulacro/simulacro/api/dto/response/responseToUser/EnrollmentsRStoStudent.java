package simulacro.simulacro.api.dto.response.responseToUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRSBasic;
import simulacro.simulacro.api.dto.response.basicResponse.EnrollmentsRSBasic;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentsRStoStudent extends EnrollmentsRSBasic {
  private CoursesRSBasic course;
}
