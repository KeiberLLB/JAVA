package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service
public class CoderService {
  @Autowired
  private CoderRepository objCoderRepository;

  public List<Coder> findAll() {
    return this.objCoderRepository.findAll();
  }

  // servicio para guardar un coder
  public Coder insert(Coder objCoder) {
    return this.objCoderRepository.save(objCoder);
  }

  public void remove(Long id) {
    this.objCoderRepository.deleteById(id);
  }

  public Coder update(Long id, Coder objCoder) {
    // buscar el coder con ese id
    Coder objCoderDB = this.findById(id);
    if (objCoderDB == null)
      return null;

    objCoderDB = objCoder;
    return this.objCoderRepository.save(objCoder);
  }

  public Coder findById(Long id) {
    return this.objCoderRepository.findById(id).orElse(null);
  }

  // Metodo para listar los coders de forma paginada
  public Page<Coder> fingPaginated(int page, int size) {
    if (page < 0) {
      page = 1;
    }

    // Crear objeto de paginacion
    Pageable objPeageable = PageRequest.of(page, size);

    return this.objCoderRepository.findAll(objPeageable);
  }
}
