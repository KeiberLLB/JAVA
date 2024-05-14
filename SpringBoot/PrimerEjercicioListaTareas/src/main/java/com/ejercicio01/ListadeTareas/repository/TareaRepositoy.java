package com.ejercicio01.ListadeTareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio01.ListadeTareas.entity.Tarea;

@Repository
public interface TareaRepositoy extends JpaRepository<Tarea, Long> {}
