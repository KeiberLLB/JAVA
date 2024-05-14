package com.riwi.vacants.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.entities.utils.dto.request.VacantRequest;
import com.riwi.vacants.entities.utils.dto.response.CompanyToVancantResponse;
import com.riwi.vacants.entities.utils.dto.response.VacantResponse;
import com.riwi.vacants.entities.utils.enums.StatusVacant;
import com.riwi.vacants.entities.utils.exceptions.IdNotFoundExeption;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.repositories.VacantRepository;
import com.riwi.vacants.services.interfaces.IVacantService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacantService implements IVacantService {
  @Autowired
  private final VacantRepository vacantRepository;
  @Autowired
  private final CompanyRepository companyRepository;

  @Override
  public Page<VacantResponse> getAll(int page, int size) {
    page = (page < 0) ? 0 : page;
    PageRequest pagination = PageRequest.of(page, size);
    return this.vacantRepository.findAll(pagination)
        .map(this::entityToResponse); //
  }

  @Override
  public VacantResponse create(VacantRequest request) {
    Company company = this.findC(request.getCompanyId());
    Vacant vacant = this.requestToEntity(request, new Vacant());
    vacant.setCompany(company);
    return this.entityToResponse(this.vacantRepository.save(vacant));
  }

  @Override
  public VacantResponse update(VacantRequest request, Long id) {
    Vacant vacant = this.findV(id);
    Company company = this.findC(request.getCompanyId());
    vacant = this.requestToEntity(request, vacant);
    vacant.setCompany(company);
    vacant.setStatus(request.getStatus());
    return this.entityToResponse(this.vacantRepository.save(vacant));
  }

  @Override
  public void delete(Long id) {
    Vacant vacant = this.findV(id);
    this.vacantRepository.delete(vacant);
  }

  @Override
  public VacantResponse getById(Long id) {
    return this.entityToResponse(this.findV(id));
  }

  private VacantResponse entityToResponse(Vacant entity) {
    VacantResponse response = new VacantResponse();
    BeanUtils.copyProperties(entity, response);
    CompanyToVancantResponse companyDto = new CompanyToVancantResponse();
    BeanUtils.copyProperties(entity.getCompany(), companyDto);
    response.setCompany(companyDto);
    return response;
  }

  private Vacant requestToEntity(VacantRequest request, Vacant vacant) {
    vacant.setTitle(request.getTitle());
    vacant.setDescription(request.getDescription());
    vacant.setStatus(StatusVacant.ACTIVE);
    return vacant;
  }

  private Company findC(String id) {
    return this.companyRepository.findById(id).orElseThrow(() -> new IdNotFoundExeption("comany"));
  }

  private Vacant findV(Long id) {
    return this.vacantRepository.findById(id).orElseThrow(() -> new IdNotFoundExeption("vacant"));
  }

}
