package simulacro.simulacro.api.dto.response.basicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import simulacro.simulacro.utils.enums.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResponse {
  private Long user_id;
  private String username;
  private String email;
  private String full_name;
  private Role role;
}
