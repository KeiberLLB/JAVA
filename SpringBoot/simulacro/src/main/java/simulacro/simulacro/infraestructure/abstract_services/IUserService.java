package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.UserRQ;
import simulacro.simulacro.api.dto.response.basicResponse.UserRS;

public interface IUserService
        extends CRUDService<UserRQ, UserRS, Long> {
        public final String FIELD_BY_SORT = "role";
}
