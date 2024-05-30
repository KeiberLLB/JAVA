package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.EnrollmentsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.EnrollmentsRS;

public interface IEnrollmentsService
    extends CRUDService<EnrollmentsRQ, EnrollmentsRS, Long> {
}
