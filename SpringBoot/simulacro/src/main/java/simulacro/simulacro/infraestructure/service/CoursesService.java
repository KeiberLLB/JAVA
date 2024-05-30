package simulacro.simulacro.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.CoursesRQ;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRS;
import simulacro.simulacro.domain.entities.Courses;
import simulacro.simulacro.domain.entities.Users;
import simulacro.simulacro.domain.repository.CoursesRepository;
import simulacro.simulacro.domain.repository.UserRepository;
import simulacro.simulacro.infraestructure.abstract_services.ICoursesService;
import simulacro.simulacro.utils.enums.SortType;
import simulacro.simulacro.utils.exception.BadRequestException;
import simulacro.simulacro.utils.messages.ErrorMessages;

@Service
@Transactional
@AllArgsConstructor
public class CoursesService implements ICoursesService {

  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final CoursesRepository coursesRepository;

  @Override
  public CoursesRS create(CoursesRQ request) {
    Courses newCourse = this.requestToEntity(request);

    return this.entityToResponse(this.coursesRepository.save(newCourse));
  }

  private CoursesRS entityToResponse(Courses entity) {
    return CoursesRS.builder()
        .course_id(entity.getCourse_id())
        .course_name(entity.getCourse_name())
        .description(entity.getDescription())
        .build();
  }

  private Courses requestToEntity(CoursesRQ request) {
    Users user = this.userRepository.findById(request.getInstructor_id())
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Instructor")));
    if (user.getRole().name().equals("STUDENT")) {
      throw new BadRequestException("El id ingresado debe ser de un instructor!");
    }

    return Courses.builder()
        .course_name(request.getCourse_name())
        .description(request.getDescription())
        .instructor(user)
        .build();
  }

  @Override
  public CoursesRS get(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public CoursesRS update(CoursesRQ request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Page<CoursesRS> getAll(int page, int size, SortType sortType) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

}
