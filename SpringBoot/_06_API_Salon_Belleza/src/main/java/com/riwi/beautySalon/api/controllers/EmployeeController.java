package com.riwi.beautySalon.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.response.EmployeeResp;
import com.riwi.beautySalon.infrastructure.abstract_services.IEmployeeService;
import com.riwi.beautySalon.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/employees")
@AllArgsConstructor
public class EmployeeController {
  @Autowired
  private final IEmployeeService employee;

  @Operation(summary = "Obtiene todos los empleados")
  @GetMapping
  public ResponseEntity<Page<EmployeeResp>> getAll(@RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestHeader(required = false) SortType sortType) {
      if (Objects.isNull(sortType)) {
      sortType = SortType.NONE;
    }
    return ResponseEntity.ok(this.employee.getAll(page - 1, size, sortType));
      }

}
