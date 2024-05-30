package simulacro.simulacro.api.dto.response.responseToUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulacro.simulacro.api.dto.response.basicResponse.SubmissionsRSBasic;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionsRStoStudent extends SubmissionsRSBasic{
  private AssignmentsRStoStudent assignment;
}
