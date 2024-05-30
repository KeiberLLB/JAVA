package simulacro.simulacro.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.UserRQ;
import simulacro.simulacro.api.dto.response.basicResponse.UserRS;
import simulacro.simulacro.domain.entities.Users;
import simulacro.simulacro.domain.repository.UserRepository;
import simulacro.simulacro.infraestructure.abstract_services.IUserService;
import simulacro.simulacro.utils.enums.SortType;
import simulacro.simulacro.utils.exception.BadRequestException;
import simulacro.simulacro.utils.messages.ErrorMessages;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

  @Autowired
  private final UserRepository userRepository;

  @Override
  public UserRS create(UserRQ request) {
    Users newuser = this.requestToEntity(request);
    return this.entityToResponse(this.userRepository.save(newuser));
  }

  @Override
  public UserRS get(Long id) {
    return this.entityToResponse(this.find(id));
  }

  @Override
  public UserRS update(UserRQ request, Long id) {
    Users user = this.find(id);
    Users userUpdate = this.requestToEntity(request);
    userUpdate.setUser_id(user.getUser_id());
    return this.entityToResponse(this.userRepository.save(userUpdate));
  }

  @Override
  public void delete(Long id) {
    this.userRepository.delete(this.find(id));
  }

  @Override
  public Page<UserRS> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.userRepository.findAll(pagination)
        .map(this::entityToResponse);
  }

  private UserRS entityToResponse(Users entity) {
    return UserRS.builder()
        .user_id(entity.getUser_id())
        .username(entity.getUsername())
        .email(entity.getEmail())
        .full_name(entity.getFull_name())
        .role(entity.getRole())
        .build();
  }

  private Users requestToEntity(UserRQ request) {
    // Users user = new Users();
    // BeanUtils.copyProperties(user, request);
    // user.setEmail(request.getEmail());

    // BeanUtils.copyProperties debe copiar todos los valores, si llega uno nulo, para en ese punto y no sigue
    return Users.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .full_name(request.getFull_name())
        .password(request.getPassword())
        .role(request.getRole())
        .build();
  }

  private Users find(Long id) {
    return this.userRepository.findById(id)
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("User")));
  }

}
