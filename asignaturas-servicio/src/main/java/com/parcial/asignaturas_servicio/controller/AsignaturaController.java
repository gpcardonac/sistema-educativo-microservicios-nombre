package com.parcial.asignaturas_servicio.controller;

import com.parcial.asignaturas_servicio.dto.AsignaturaDTO;
import com.parcial.asignaturas_servicio.entity.Asignatura;
import com.parcial.asignaturas_servicio.service.AsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService service) {
        this.asignaturaService = service;
    }

    @PostMapping
    public ResponseEntity<Asignatura> crear(@RequestBody AsignaturaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(asignaturaService.obtenerPorId(id));
    }

    @GetMapping("/existe")
    public ResponseEntity<Boolean> existe(@RequestParam String nombre) {
        return ResponseEntity.ok(asignaturaService.existePorNombre(nombre));
    }

    @GetMapping
    public ResponseEntity<List<Asignatura>> listar() {
        return ResponseEntity.ok(asignaturaService.obtenerTodas());
    }

}

