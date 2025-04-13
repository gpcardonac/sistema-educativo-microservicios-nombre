package com.parcial.asignaturas_servicio.service;

import com.parcial.asignaturas_servicio.dto.AsignaturaDTO;
import com.parcial.asignaturas_servicio.entity.Asignatura;

import java.util.List;

public interface AsignaturaService {
    Asignatura crear(AsignaturaDTO dto);
    Asignatura obtenerPorId(Long id);
    boolean existePorNombre(String nombre);
    List<Asignatura> obtenerTodas();
}

