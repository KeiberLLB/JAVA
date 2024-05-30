package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.LessonsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.LessonsRSBasic;

public interface ILessonsService
    extends CRUDService<LessonsRQ, LessonsRSBasic, Long> {
}
