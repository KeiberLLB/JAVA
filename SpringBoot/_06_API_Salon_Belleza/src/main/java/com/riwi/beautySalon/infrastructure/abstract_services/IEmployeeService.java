package com.riwi.beautySalon.infrastructure.abstract_services;

import java.util.List;

import com.riwi.beautySalon.api.dto.request.EmployeeReq;
import com.riwi.beautySalon.api.dto.response.EmployeeResp;

public interface IEmployeeService extends CrudService<EmployeeReq, EmployeeResp, Long> {
  public List<EmployeeResp> search(String name);

  public String FIELD_BY_SORT = "firstName";
}
