package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.LessonsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.LessonsRS;

public interface ILessonsService
    extends CRUDService<LessonsRQ, LessonsRS, Long> {
}
