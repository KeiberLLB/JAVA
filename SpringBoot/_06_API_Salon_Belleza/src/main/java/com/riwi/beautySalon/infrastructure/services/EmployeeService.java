package com.riwi.beautySalon.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.EmployeeReq;
import com.riwi.beautySalon.api.dto.response.EmployeeResp;
import com.riwi.beautySalon.api.exceptions.BadRequestException;
import com.riwi.beautySalon.domain.entities.Employee;
import com.riwi.beautySalon.domain.repositories.EmployeeRepository;
import com.riwi.beautySalon.infrastructure.abstract_services.IEmployeeService;
import com.riwi.beautySalon.utils.enums.SortType;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {
  @Autowired
  private final EmployeeRepository employeeRepository;

  @Override
  public EmployeeResp create(EmployeeReq request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public EmployeeResp get(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public EmployeeResp update(EmployeeReq request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @SuppressWarnings("null")
  @Override
  public Page<EmployeeResp> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.employeeRepository.findAll(pagination).map(this::entityToResp);

  }

  @Override
  public List<EmployeeResp> search(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'search'");
  }

  private EmployeeResp entityToResp(Employee entity) {
    EmployeeResp resp = new EmployeeResp();
    BeanUtils.copyProperties(entity, resp);
    return resp;
  }

  private Employee reqToEntity(EmployeeReq req, Employee entity) {
    BeanUtils.copyProperties(req, entity);
    return entity;
  }

  private Employee find(Long id) {
    return this.employeeRepository.findById(id).orElseThrow(() -> new BadRequestException("No found result"));
  
  }

}
