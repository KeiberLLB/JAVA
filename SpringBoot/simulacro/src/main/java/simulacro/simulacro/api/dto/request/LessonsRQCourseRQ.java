package simulacro.simulacro.api.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonsRQCourseRQ {
  private String lesson_title;
  private String content;
  private CoursesRQ coursesRQ;
  private List<AssignmentsRQ> lAssignments;
}
