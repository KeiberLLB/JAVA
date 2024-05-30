package simulacro.simulacro.api.dto.response.responseToUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import simulacro.simulacro.api.dto.response.CourseRS;
import simulacro.simulacro.api.dto.response.basicResponse.MessagesRSBasic;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesSenderRS extends MessagesRSBasic {
  private CourseRS course;
}
