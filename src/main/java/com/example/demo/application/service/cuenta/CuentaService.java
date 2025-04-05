package com.example.demo.application.service.cuenta;

import com.example.demo.infrastructure.dto.CuentaDto;

import java.util.List;

public interface CuentaService {

    CuentaDto crear(CuentaDto dto);
    CuentaDto actualizar(Long numeroCuenta, CuentaDto dto);
    CuentaDto obtener(Long numeroCuenta);
    List<CuentaDto> listar();

}
