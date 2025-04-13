package com.parcial.matriculas_servicio.controller;

import com.parcial.matriculas_servicio.dto.MatriculaRequest;
import com.parcial.matriculas_servicio.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody MatriculaRequest request) {
        service.registrarMatricula(request);
        return ResponseEntity.ok("Matrícula registrada");
    }
}

