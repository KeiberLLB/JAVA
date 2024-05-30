package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.SubmissionsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.SubmissionsRSBasic;

public interface ISubmissionsService
    extends CRUDService<SubmissionsRQ, SubmissionsRSBasic, Long> {
}
