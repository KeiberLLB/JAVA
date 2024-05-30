package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.AssignmentsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.AssignmentsRS;

public interface IAssignmentsService
    extends CRUDService<AssignmentsRQ, AssignmentsRS, Long> {
}
