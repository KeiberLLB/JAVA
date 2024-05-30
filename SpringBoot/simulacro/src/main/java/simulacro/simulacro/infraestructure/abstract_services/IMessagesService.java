package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.MessagesRQ;
import simulacro.simulacro.api.dto.response.basicResponse.MessagesRS;

public interface IMessagesService
    extends CRUDService<MessagesRQ, MessagesRS, Long> {

}
