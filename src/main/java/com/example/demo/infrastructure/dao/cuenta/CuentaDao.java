package com.example.demo.infrastructure.dao.cuenta;

import com.example.demo.infrastructure.dto.CuentaDto;

import java.util.List;

public interface CuentaDao {

    CuentaDto guardar(CuentaDto cuentaDto);
    CuentaDto actualizar(Long numeroCuenta, CuentaDto cuentaDto);
    CuentaDto obtenerPorNumero(Long numeroCuenta);
    List<CuentaDto> listar();

}
