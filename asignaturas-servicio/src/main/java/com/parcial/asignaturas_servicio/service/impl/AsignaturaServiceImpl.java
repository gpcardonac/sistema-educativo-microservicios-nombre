package com.parcial.asignaturas_servicio.service.impl;

import com.parcial.asignaturas_servicio.dto.AsignaturaDTO;
import com.parcial.asignaturas_servicio.entity.Asignatura;
import com.parcial.asignaturas_servicio.repository.AsignaturaRepository;
import com.parcial.asignaturas_servicio.service.AsignaturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaServiceImpl(AsignaturaRepository repository) {
        this.asignaturaRepository = repository;
    }

    @Override
    public Asignatura crear(AsignaturaDTO dto) {
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(dto.getNombre());
        asignatura.setDescripcion(dto.getDescripcion());
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura obtenerPorId(Long id) {
        return asignaturaRepository.findById(id).orElseThrow();
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return asignaturaRepository.findByNombre(nombre).isPresent();
    }

    @Override
    public List<Asignatura> obtenerTodas() {
        return asignaturaRepository.findAll();
    }

}

