package com.example.demo.application.service.cuenta.impl;

import com.example.demo.application.service.cuenta.CuentaService;
import com.example.demo.infrastructure.dao.cuenta.CuentaDao;
import com.example.demo.infrastructure.dto.CuentaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {

    private final CuentaDao cuentaDao;

    @Override
    public CuentaDto crear(CuentaDto dto) {
        return cuentaDao.guardar(dto);
    }

    @Override
    public CuentaDto actualizar(Long numeroCuenta, CuentaDto dto) {
        return cuentaDao.actualizar(numeroCuenta, dto);
    }

    @Override
    public CuentaDto obtener(Long numeroCuenta) {
        return cuentaDao.obtenerPorNumero(numeroCuenta);
    }

    @Override
    public List<CuentaDto> listar() {
        return cuentaDao.listar();
    }

}
