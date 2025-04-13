package com.parcial.matriculas_servicio.client;

import com.parcial.matriculas_servicio.dto.AsignaturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaClient {
    @GetMapping("/api/asignaturas/{id}")
    AsignaturaDTO obtenerAsignatura(@PathVariable Long id);
}

