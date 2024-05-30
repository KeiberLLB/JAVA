package simulacro.simulacro.infraestructure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.CoursesRQ;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRSBasic;
import simulacro.simulacro.api.dto.response.basicResponse.UserRSBasic;
import simulacro.simulacro.api.dto.response.CourseRS;
import simulacro.simulacro.domain.entities.Courses;
import simulacro.simulacro.domain.entities.Users;
import simulacro.simulacro.domain.repository.CoursesRepository;
import simulacro.simulacro.domain.repository.UserRepository;
import simulacro.simulacro.infraestructure.abstract_services.ICoursesService;
import simulacro.simulacro.infraestructure.abstract_services.IUserService;
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
  public CourseRS create(CoursesRQ request) {
    Courses newCourse = this.requestToEntity(request);

    return this.entityToResponse(this.coursesRepository.save(newCourse));
  }

  @Override
  public CourseRS get(Long id) {
    return this.entityToResponse(this.find(id));
  }

  @Override
  public CourseRS update(CoursesRQ request, Long id) {
    Courses course = this.find(id);
    Courses courseUpdate = this.requestToEntity(request);
    courseUpdate.setCourse_id(course.getCourse_id());
    return this.entityToResponse(this.coursesRepository.save(courseUpdate));
  }

  @Override
  public void delete(Long id) {
    this.coursesRepository.delete(this.find(id));
  }

  @Override
  public Page<CourseRS> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.coursesRepository.findAll(pagination)
        .map(this::entityToResponse);
  }

  private CourseRS entityToResponse(Courses entity) {

    return CourseRS.builder()
        .course_id(entity.getCourse_id())
        .course_name(entity.getCourse_name())
        .description(entity.getDescription())
        .instructor(UserRSBasic.builder()
            .user_id(entity.getInstructor().getUser_id())
            .username(entity.getInstructor().getUsername())
            .email(entity.getInstructor().getEmail())
            .full_name(entity.getInstructor().getFull_name())
            .role(entity.getInstructor().getRole())
            .build())
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

  private Courses find(Long id) {
    return this.coursesRepository.findById(id)
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Course")));
  }
}
