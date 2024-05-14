package com.riwi.vacants.entities.utils.dto.errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
// se usa SuperBuilder porque estamos implementando de Serializable
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorResponse implements Serializable {
  private String status;
  private Integer code;
}
