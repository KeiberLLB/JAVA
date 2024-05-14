package com.riwi.operaciones.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operaciones.entities.Operaciones;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationsController {
  @PostMapping(path = "/add")
  public String add(@RequestBody Operaciones objoperations) {
    String message = String.valueOf(objoperations.getNum1() + objoperations.getNum2());
    return objoperations.getNum1() + " + " + objoperations.getNum2() + " = " + message;
  }

  @PostMapping(path = "/subtract")
  public String subtract(@RequestBody Operaciones objoperations) {
    String message = String.valueOf(objoperations.getNum1() - objoperations.getNum2());
    return objoperations.getNum1() + " - " + objoperations.getNum2() + " = " + message;
  }
  @PostMapping(path = "/multiply")
  public String multiply(@RequestBody Operaciones objoperations) {
    String message = String.valueOf(objoperations.getNum1() * objoperations.getNum2());
    return objoperations.getNum1() + " * " + objoperations.getNum2() + " = " + message;
  }
  @PostMapping(path = "/divide")
  public String divide(@RequestBody Operaciones objoperations) {

    if (objoperations.getNum2() == 0) {
      return "No se puede dividir por 0";
    }

    String message = String.valueOf(objoperations.getNum1() / objoperations.getNum2());
    return objoperations.getNum1() + " / " + objoperations.getNum2() + " = " + message;
  }

}
