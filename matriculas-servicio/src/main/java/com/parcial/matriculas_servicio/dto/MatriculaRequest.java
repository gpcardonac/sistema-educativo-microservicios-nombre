package com.parcial.matriculas_servicio.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatriculaRequest {
    private Long usuarioId;
    private List<Long> asignaturasIds;
}

