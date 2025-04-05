package com.example.demo.application.service.movimiento;

import com.example.demo.infrastructure.dto.MovimientoDto;

import java.util.List;

public interface MovimientoService {

    MovimientoDto registrar(MovimientoDto dto);
    MovimientoDto obtener(Long id);
    List<MovimientoDto> listar();

}
