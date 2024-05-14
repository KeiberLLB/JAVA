package com.riwi.vacants.entities.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
  @Size(min = 0, max = 40, message ="El nombre supera la cantidad de caracteres permitidos")
  @NotBlank(message = "El nombre de la compañoa es requerido")
  private String name;
  @NotBlank(message = "La ubicación es requerida")
  private String location;
  @Size(min = 0, max = 40, message = "El contacto supera la cantidad de caracteres permitido")
  @NotBlank(message = "La información de contacto es requerida")
  private String contact;
}
