package simulacro.simulacro.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
  @NotBlank(message = "El email es requerido")
  @Email
  private String email;
  private String password;
  private String full_name;
  private Role role;
}
