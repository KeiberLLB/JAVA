package com.riwi.beautySalon.api.controllers;

import java.util.Objects;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.error.ErrorsResp;
import com.riwi.beautySalon.api.dto.request.ServiceReq;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.infrastructure.abstract_services.IServiceService;
import com.riwi.beautySalon.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/services/public/get")
@AllArgsConstructor
public class ServiceController {
  @Autowired
  private final IServiceService service;

  @Operation(summary = "Obtiene toda la lista de servicios")
  @GetMapping
  public ResponseEntity<Page<ServiceResp>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestHeader(required = false) SortType sortType) {
    if (Objects.isNull(sortType)) {
      sortType = SortType.NONE;
    }
    return ResponseEntity.ok(this.service.getAll(page - 1, size, sortType));
  }

  @ApiResponse(responseCode = "400", description = "Cuando el request no es valido", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class)) })
  @PostMapping
  public ResponseEntity<ServiceResp> create(@Validated @RequestBody ServiceReq request) {
    return ResponseEntity.ok(this.service.create(request));
  }

  @ApiResponse(responseCode = "400", description = "Cuando el request no es valido", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class)) })
  @PutMapping(path = "/{id}")
  public ResponseEntity<ServiceResp> update(@Validated @RequestBody ServiceReq request, @PathVariable Long id) {
    return ResponseEntity.ok(this.service.update(request, id));
  }

  @ApiResponse(responseCode = "400", description = "Cuando el id no es valido", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class)) })
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.service.delete(id);
    return ResponseEntity.ok().build();
  }

  @ApiResponse(responseCode = "400", description = "Cuando el id no es valido", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class)) })
  @GetMapping(path = "/{id}")
  public ResponseEntity<ServiceResp> getById(@PathVariable Long id) {
    return ResponseEntity.ok(this.service.get(id));
  }
}
