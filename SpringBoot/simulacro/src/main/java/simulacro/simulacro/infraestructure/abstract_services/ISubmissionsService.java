package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.SubmissionsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.SubmissionsRS;

public interface ISubmissionsService
    extends CRUDService<SubmissionsRQ, SubmissionsRS, Long> {
}
