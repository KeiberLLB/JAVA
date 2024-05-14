package com.riwi.vacants.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
//configuracion de swagger
@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para administrar empresas y vacantes de empresas", version = "1.0", description = "Documentación api de administracion de empresas y vacantes"))
public class OpenApiConfig {
  
}
