package simulacro.simulacro.api.dto.response.basicResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import simulacro.simulacro.utils.enums.Role;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserRSBasic {
  private Long user_id;
  private String username;
  private String email;
  private Role role;
  private String full_name;
}
