package com.riwi.beautySalon.infrastructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.beautySalon.api.dto.request.ClientReq;
import com.riwi.beautySalon.api.dto.response.AppointmentToClient;
import com.riwi.beautySalon.api.dto.response.ClientResp;
import com.riwi.beautySalon.api.dto.response.EmployeeResp;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.domain.entities.Appointment;
import com.riwi.beautySalon.domain.entities.ClientEntity;
import com.riwi.beautySalon.domain.repositories.ClientRepository;
import com.riwi.beautySalon.infrastructure.abstract_services.IClientService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ClientService implements IClientService {
  @Autowired
  private final ClientRepository clientRepository;

  @Override
  public ClientResp create(ClientReq request) {
    ClientEntity entity = this.clientRepository.save(this.reqToEntity(request, new ClientEntity()));
    return this.entityToResp(entity);
  }

  @Override
  public ClientResp get(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public ClientResp update(ClientReq request, Long id) {
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
  public Page<ClientResp> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.clientRepository.findAll(pagination).map(this::entityToResp);
  }

  @Override
  public List<ClientResp> search(String name) {
    List<ClientResp> list = this.clientRepository.findByFirstNameContaining(name).stream().map(this::entityToResp).toList();
    return list;
  }

  private ClientResp entityToResp(ClientEntity entity) {
    List<AppointmentToClient> list = entity.getAppointments().stream().map(this::entityToResponseAppointment)
        .collect(Collectors.toList());

    return ClientResp.builder()
        .id(entity.getId())
        .firstName(entity.getFirstName())
        .lastName(entity.getLastName())
        .email(entity.getEmail())
        .phone(entity.getPhone())
        .appointments(list)
        .build();
  }

  private AppointmentToClient entityToResponseAppointment(Appointment entity) {

    ServiceResp service = new ServiceResp();
    BeanUtils.copyProperties(entity.getService(), service);

    EmployeeResp employee = new EmployeeResp();
    BeanUtils.copyProperties(entity.getEmployee(), employee);

    return AppointmentToClient.builder()
        .id(entity.getId())
        .dateTime(entity.getDateTime())
        .duration(entity.getDuration())
        .comments(entity.getComments())
        .service(service)
        .employee(employee)
        .build();

  }

  private ClientEntity reqToEntity(ClientReq req, ClientEntity entity) {
    BeanUtils.copyProperties(req, entity);
    return entity;
  }

}
