package simulacro.simulacro.infraestructure.abstract_services;

import simulacro.simulacro.api.dto.request.MessagesRQ;
import simulacro.simulacro.api.dto.response.basicResponse.MessagesRSBasic;

public interface IMessagesService
    extends CRUDService<MessagesRQ, MessagesRSBasic, Long> {

}
