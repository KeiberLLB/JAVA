package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.LessonsRQ;
import simulacro.simulacro.api.dto.response.LessonsRS;


public interface ILessonsService
        extends CRUDService<LessonsRQ, LessonsRS, Long> {
        public final String FIELD_BY_SORT = "lesson_title";
}
