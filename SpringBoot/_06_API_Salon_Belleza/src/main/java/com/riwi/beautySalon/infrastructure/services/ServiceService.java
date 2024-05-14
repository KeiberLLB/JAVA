package com.riwi.beautySalon.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.beautySalon.api.dto.request.ServiceReq;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.api.exceptions.BadRequestException;
import com.riwi.beautySalon.domain.entities.ServiceEntity;
import com.riwi.beautySalon.domain.repositories.ServiceRepository;
import com.riwi.beautySalon.infrastructure.abstract_services.IServiceService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ServiceService implements IServiceService {
  @Autowired
  private final ServiceRepository serviceRepository;

  @Override
  public ServiceResp create(ServiceReq request) {
    ServiceEntity entity = this.serviceRepository.save(this.reqToEntity(request, new ServiceEntity()));
    return this.entityToResp(entity);
  }

  @Override
  public ServiceResp get(Long id) {
    ServiceEntity entity = this.find(id);
    return this.entityToResp(entity);
  }

  @Override
  public ServiceResp update(ServiceReq request, Long id) {
    ServiceEntity entityUpdate = this.find(id);
    ServiceEntity entity = this.reqToEntity(request, entityUpdate);
    return this.entityToResp(this.serviceRepository.save(entity));
  }

  @Override
  public void delete(Long id) {
    ServiceEntity entity = this.find(id);
    this.serviceRepository.delete(entity);
  }

  @SuppressWarnings("null")
  @Override
  public Page<ServiceResp> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;

    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.serviceRepository.findAll(pagination).map(this::entityToResp);
  }

  @Override
  public List<ServiceResp> search(String firt_name) {
    List<ServiceResp> listEntity = this.serviceRepository.findByNameContaining(
        firt_name).stream().map(this::entityToResp)
        .toList();
    return listEntity;
  }

  private ServiceResp entityToResp(ServiceEntity entity) {
    ServiceResp resp = new ServiceResp();

    // ESTO ES LO MISMOQUE EL BeanUtils.copyProperties(entity, resp);
    // return ServiceResp.builder()
    // .id(entity.getId())
    // .name(entity.getName())
    // .description(entity.getDescription())
    // .price(entity.getPrice())
    // .build();

    BeanUtils.copyProperties(entity, resp);
    return resp;
  }

  // CON EL METODO .builder() NO SE PUEDE APLICAR EL SAVE Y UPDATE EN EL MISMO
  // METODO
  private ServiceEntity reqToEntity(ServiceReq req, ServiceEntity entityService) {
    BeanUtils.copyProperties(req, entityService);
    return entityService;
  }

  private ServiceEntity find(Long id) {
    return this.serviceRepository.findById(id).orElseThrow(() -> new BadRequestException("Not found service"));
  }
}
