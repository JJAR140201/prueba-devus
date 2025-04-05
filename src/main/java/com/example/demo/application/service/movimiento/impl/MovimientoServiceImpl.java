package com.example.demo.application.service.movimiento.impl;

import com.example.demo.application.service.movimiento.MovimientoService;
import com.example.demo.infrastructure.dao.movimiento.MovimientoDao;
import com.example.demo.infrastructure.dto.MovimientoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoDao movimientoDao;

    @Override
    public MovimientoDto registrar(MovimientoDto dto) {
        return movimientoDao.registrarMovimiento(dto);
    }

    @Override
    public MovimientoDto obtener(Long id) {
        return movimientoDao.obtenerMovimiento(id);
    }

    @Override
    public List<MovimientoDto> listar() {
        return movimientoDao.listarMovimientos();
    }

}
