package simulacro.simulacro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRSBasic;
import simulacro.simulacro.api.dto.response.basicResponse.UserRSBasic;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRS extends CoursesRSBasic {
  private UserRSBasic instructor;
}
