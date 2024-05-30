package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.CoursesRQ;
import simulacro.simulacro.api.dto.response.CourseRS;

public interface ICoursesService
        extends CRUDService<CoursesRQ, CourseRS, Long> {
        public final String FIELD_BY_SORT = "course_name";
}
