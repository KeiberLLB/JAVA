package com.riwi.vacants.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.entities.utils.dto.request.VacantRequest;
import com.riwi.vacants.entities.utils.dto.response.VacantResponse;
import com.riwi.vacants.services.interfaces.IVacantService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/vacant")
@AllArgsConstructor
public class VacantController {
  @Autowired
  private final IVacantService vacantService;

  @GetMapping
  public ResponseEntity<Page<VacantResponse>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "3") int size) {

    return ResponseEntity.ok(this.vacantService.getAll(page - 1, size));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<VacantResponse> getById(@PathVariable Long id) {
    return ResponseEntity.ok(this.vacantService.getById(id));
  }

  @PostMapping
  public ResponseEntity<VacantResponse> insert(@Validated @RequestBody VacantRequest entity) {
    return ResponseEntity.ok(this.vacantService.create(entity));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
    Map<String, String> response = new HashMap<>();
    response.put("message", "vacante eliminada correctamente");
    this.vacantService.delete(id);
    return ResponseEntity.ok(response);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<VacantResponse> update(
      @Validated @RequestBody VacantRequest vacant, @PathVariable Long id) {
    return ResponseEntity.ok(this.vacantService.update(vacant, id));
  }

}
