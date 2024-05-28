package simulacro.simulacro.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import simulacro.simulacro.domain.utils.enums.Role;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_id;
  @Column(length = 50, nullable = false)
  private String username;
  @Column(length = 100, nullable = false)
  private String email;
  @Column(length = 255, nullable = false)
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;
  @Column(length = 100, nullable = false)
  private String full_name;

  @OneToMany(mappedBy = "courses", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Courses> courses;
  @OneToMany(mappedBy = "enrollments", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Enrollments> enrollments;
  @OneToMany(mappedBy = "messages", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Messages> messages;

  

}
