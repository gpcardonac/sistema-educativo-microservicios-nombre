package com.parcial.matriculas_servicio.service.impl;

import com.parcial.matriculas_servicio.client.AsignaturaClient;
import com.parcial.matriculas_servicio.client.UsuarioClient;
import com.parcial.matriculas_servicio.dto.AsignaturaDTO;
import com.parcial.matriculas_servicio.dto.MatriculaRequest;
import com.parcial.matriculas_servicio.dto.UsuarioDTO;
import com.parcial.matriculas_servicio.entity.Matricula;
import com.parcial.matriculas_servicio.repository.MatriculaRepository;
import com.parcial.matriculas_servicio.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository repo;
    @Autowired private UsuarioClient usuarioClient;
    @Autowired private AsignaturaClient asignaturaClient;

    @Override
    public void registrarMatricula(MatriculaRequest request) {
        UsuarioDTO usuario = usuarioClient.obtenerUsuario(request.getUsuarioId());
        if (usuario == null) throw new RuntimeException("Usuario no encontrado");

        for (Long id : request.getAsignaturasIds()) {
            AsignaturaDTO asig = asignaturaClient.obtenerAsignatura(id);
            if (asig == null) throw new RuntimeException("Asignatura no encontrada: " + id);

            Matricula matricula = new Matricula();
            matricula.setUsuarioId(usuario.getId());
            matricula.setAsignaturaId(asig.getId());
            matricula.setFechaMatricula(LocalDate.now());
            repo.save(matricula);
        }
    }
}

