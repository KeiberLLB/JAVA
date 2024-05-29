package simulacro.simulacro.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import simulacro.simulacro.utils.enums.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRQ {
  private String username;
  private String email;
  private String password;
  private String full_name;
  private Role role;
}
