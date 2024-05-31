package simulacro.simulacro.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.CoursesRQ;
import simulacro.simulacro.api.dto.request.LessonsRQCourseRQ;
import simulacro.simulacro.domain.entities.Courses;
import simulacro.simulacro.domain.entities.Lessons;
import simulacro.simulacro.domain.entities.Users;
import simulacro.simulacro.domain.repository.LessonsRepository;
import simulacro.simulacro.domain.repository.UserRepository;
import simulacro.simulacro.utils.exception.BadRequestException;
import simulacro.simulacro.utils.messages.ErrorMessages;

@Service
@Transactional
@AllArgsConstructor
public class ServicePL {

  @Autowired
  private final LessonsRepository lessonsRepository;

  @Autowired
  private final UserRepository userRepository;
  public Void create(LessonsRQCourseRQ request) {
    Lessons lesson = this.requestToEntity(request);
    return null;
    
  }

  private Lessons requestToEntity(LessonsRQCourseRQ request) {
    Courses course = this.requestToEntityforLesson(request.getCoursesRQ());
    return Lessons.builder()
        .content(request.getContent())
        .build();
  }

  private Courses requestToEntityforLesson(CoursesRQ request) {
    Users user = this.userRepository.findById(request.getInstructor_id())
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Instructor")));
    
    return Courses.builder()
        .course_name(request.getCourse_name())
        .description(request.getDescription())
        .instructor(user)
        .build();
  }

  
}
