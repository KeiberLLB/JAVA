package simulacro.simulacro.infraestructure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.LessonsRQ;
import simulacro.simulacro.api.dto.response.CourseRS;
import simulacro.simulacro.api.dto.response.LessonsRS;
import simulacro.simulacro.api.dto.response.basicResponse.UserRSBasic;
import simulacro.simulacro.domain.entities.Assignments;
import simulacro.simulacro.domain.entities.Courses;
import simulacro.simulacro.domain.entities.Lessons;
import simulacro.simulacro.domain.repository.CoursesRepository;
import simulacro.simulacro.domain.repository.LessonsRepository;
import simulacro.simulacro.infraestructure.abstract_services.ILessonsService;
import simulacro.simulacro.utils.enums.SortType;
import simulacro.simulacro.utils.exception.BadRequestException;
import simulacro.simulacro.utils.messages.ErrorMessages;

@Service
@Transactional
@AllArgsConstructor
public class LessonsService implements ILessonsService {

  @Autowired
  private final LessonsRepository lessonsRepository;

  @Autowired
  private final CoursesRepository coursesRepository;

  @Override
  public LessonsRS create(LessonsRQ request) {
    Lessons newLessons = this.requestToEntity(request);
    return this.entityToResponse(this.lessonsRepository.save(newLessons));
  }

  
  @Override
  public LessonsRS get(Long id) {
    return this.entityToResponse(this.find(id));
  }
  
  @Override
  public LessonsRS update(LessonsRQ request, Long id) {
    Lessons lesson = this.find(id);
    Lessons lessonUpdate = this.requestToEntity(request);
    lessonUpdate.setLesson_id(lesson.getLesson_id());
    lessonUpdate.setCourse(this.coursesRepository.findById(request.getCourse_id())
    .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Course"))));
    return this.entityToResponse(this.lessonsRepository.save(lessonUpdate));
  }
  
  @Override
  public void delete(Long id) {
    this.lessonsRepository.delete(this.find(id));
  }
  
  @Override
  public Page<LessonsRS> getAll(int page, int size, SortType sortType) {
    if (page < 0)
    page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.lessonsRepository.findAll(pagination)
    .map(this::entityToResponse);
  }
  
  private Lessons find(Long id) {
    return this.lessonsRepository.findById(id)
    .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Lesson")));
  }
  
  private LessonsRS entityToResponse(Lessons save) {
    return LessonsRS.builder()
        .lesson_id(save.getLesson_id())
        .lesson_title(save.getLesson_title())
        .content(save.getContent())
        .course(CourseRS
            .builder()
            .course_id(save.getCourse().getCourse_id())
            .course_name(save.getCourse().getCourse_name())
            .description(save.getCourse().getDescription())
            .instructor(UserRSBasic
                .builder()
                .user_id(save.getCourse().getInstructor().getUser_id())
                .username(save.getCourse().getInstructor().getUsername())
                .email(save.getCourse().getInstructor().getEmail())
                .full_name(save.getCourse().getInstructor().getFull_name())
                .role(save.getCourse().getInstructor()
                    .getRole())
                .build())
            .build())
        .build();
  }
  
  private Lessons requestToEntity(LessonsRQ request) {
    Courses courses = this.coursesRepository.findById(request.getCourse_id())
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Course")));
    List<Assignments> assignments = new ArrayList<>();
  
    return Lessons.builder()
        .assignments(assignments)
        .content(request.getContent())
        .lesson_title(request.getLesson_title())
        .course(courses)
        .build();
  }
}
