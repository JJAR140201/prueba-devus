package com.example.demo.infrastructure.dao.movimiento;

import com.example.demo.infrastructure.dto.MovimientoDto;

import java.util.List;

public interface MovimientoDao {

    MovimientoDto registrarMovimiento(MovimientoDto dto);
    MovimientoDto obtenerMovimiento(Long id);
    List<MovimientoDto> listarMovimientos();

}
