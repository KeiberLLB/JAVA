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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import simulacro.simulacro.utils.enums.Role;

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

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Courses> courses;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Messages> messages_sender;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Messages> messages_receiver;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Submissions> submissions;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Enrollments> enrollments;

}
