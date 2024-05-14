package com.ejercicio01.ListadeTareas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ejercicio01.ListadeTareas.entity.Tarea;
import com.ejercicio01.ListadeTareas.repository.TareaRepositoy;

@Service
public class TareaService {
  @Autowired
  private TareaRepositoy objTareaRepository;

  public List<Tarea> findAll() {
    return this.objTareaRepository.findAll();
  }

  public Tarea save(Tarea objTarea) {
    return this.objTareaRepository.save(objTarea);
  }

  public void delete(Long id) {
    this.objTareaRepository.deleteById(id);
  }

  public Tarea update(Long id, Tarea objTarea) {
    // buscar el Tarea con ese id
    Tarea objTareaDB = this.findById(id);
    if (objTareaDB == null)
      return null;

    objTareaDB = objTarea;
    return this.objTareaRepository.save(objTarea);
  }

  public Tarea findById(Long id) {
    return this.objTareaRepository.findById(id).orElse(null);
  }

  public Page<Tarea> fingPaginated(int page, int size) {
    if (page < 0) {
      page = 1;
    }
    Pageable objPeageable = PageRequest.of(page, size);
    return this.objTareaRepository.findAll(objPeageable);
  }
}
