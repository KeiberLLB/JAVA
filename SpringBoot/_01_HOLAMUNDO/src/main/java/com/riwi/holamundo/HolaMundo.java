package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Indica que esta clase será un controlador
@Controller
// RequestMapping Crea la ruta base del controlador
@RequestMapping("/controller")
public class HolaMundo {

  // GetMapping crea una ruta especifica para el metodo
  @GetMapping("/holamundo")
  // RespnseBody nos permite responder en el navegador
  @ResponseBody
  public String mostrarMensaje() {
    return "Hola Mundo";
  }

  @GetMapping("/suma")
  @ResponseBody
  public String suma() {
    int a = 0, b = 4;
    return String.valueOf(a + b);
  }
}
