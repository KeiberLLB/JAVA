package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.EnrollmentsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.EnrollmentsRSBasic;

public interface IEnrollmentsService
    extends CRUDService<EnrollmentsRQ, EnrollmentsRSBasic, Long> {
}
