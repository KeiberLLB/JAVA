package simulacro.simulacro.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import simulacro.simulacro.utils.enums.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
  private Long user_id;
  private String username;
  private String email;
  private Role role;
  private String full_name;
  private List<MessagesSenderResponse> messages_sender;
  private List<MessagesReceiverResponse> messages_receiver;
}
