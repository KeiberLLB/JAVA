package simulacro.simulacro.api.dto.response.responseToUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRSBasic;
import simulacro.simulacro.api.dto.response.basicResponse.LessonsRSBasic;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonsRStoStudent extends LessonsRSBasic{
  private CoursesRSBasic course;
}
