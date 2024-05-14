package com.riwi.beautySalon.infrastructure.abstract_services;

import java.util.List;

import com.riwi.beautySalon.api.dto.request.ClientReq;
import com.riwi.beautySalon.api.dto.response.ClientResp;

public interface IClientService extends CrudService<ClientReq, ClientResp, Long> {
  public List<ClientResp> search(String name);
  public String FIELD_BY_SORT = "firstName";
}
