package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//configuracion de swagger
@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para administrar un salon de Belleza", version = "1.0", description = "Documentación api de administracion de un salon de Belleza"))
public class OpenApiConfig {
  
}
