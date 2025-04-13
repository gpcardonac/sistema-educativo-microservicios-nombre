package com.parcial.asignaturas_servicio.repository;

import com.parcial.asignaturas_servicio.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    Optional<Asignatura> findByNombre(String nombre);
}

