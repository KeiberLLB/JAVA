package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.UserRQ;
import simulacro.simulacro.api.dto.response.basicResponse.UserRSBasic;

public interface IUserService
        extends CRUDService<UserRQ, UserRSBasic, Long> {
        public final String FIELD_BY_SORT = "role";
}
