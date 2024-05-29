package simulacro.simulacro.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para administrar cursos y materiales educativos en linea", version = "1.0", description = "Documentación api de administracion de cursos y materiales educativos en linea"))
public class OpenApiConfig {

}
