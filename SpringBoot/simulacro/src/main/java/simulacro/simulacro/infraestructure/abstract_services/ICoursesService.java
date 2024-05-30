package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.CoursesRQ;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRS;

public interface ICoursesService
    extends CRUDService<CoursesRQ, CoursesRS, Long> {
}
