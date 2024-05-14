package com.riwi.vacants.entities.utils.exceptions;

//RunTimeException es la clase general de errrores de java
//La utilizaremos para utilizar su constructor y generar errores
public class IdNotFoundExeption extends RuntimeException {
  private static final String ERROR_MESSAGE = "No hay registros en la entidad %s con el id suministrado.";

  // Utilizamos el constructor de RuntimeException y enviamos el mensaje
  // inyectando el nombre de la entidad
  public IdNotFoundExeption(String nameEntity) {
    super(String.format(ERROR_MESSAGE, nameEntity));
  }
}
