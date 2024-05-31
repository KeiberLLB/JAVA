package simulacro.simulacro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import simulacro.simulacro.api.dto.response.basicResponse.LessonsRSBasic;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor  
public class LessonsRS extends LessonsRSBasic{
  private CourseRS course;
}
