package simulacro.simulacro.api.dto.response.basicResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import simulacro.simulacro.utils.enums.Role;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserRS {
  private Long user_id;
  private String username;
  private String email;
  private Role role;
  private String full_name;
}
