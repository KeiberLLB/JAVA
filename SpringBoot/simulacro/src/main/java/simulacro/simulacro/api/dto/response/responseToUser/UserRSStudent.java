package simulacro.simulacro.api.dto.response.responseToUser;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import simulacro.simulacro.api.dto.response.basicResponse.UserRSBasic;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserRSStudent extends UserRSBasic {
  private List<MessagesSenderRS> messages_sender;
  private List<MessagesReceiverRS> messages_receiver;
  private List<EnrollmentsRStoStudent> courses;
  private List<SubmissionsRStoStudent> submissions;
}
