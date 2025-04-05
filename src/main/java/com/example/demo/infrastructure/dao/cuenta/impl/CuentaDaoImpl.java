package com.example.demo.infrastructure.dao.cuenta.impl;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Cuenta;
import com.example.demo.infrastructure.dao.cuenta.CuentaDao;
import com.example.demo.infrastructure.dto.CuentaDto;
import com.example.demo.infrastructure.repository.ClienteRepository;
import com.example.demo.infrastructure.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CuentaDaoImpl implements CuentaDao {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public CuentaDto guardar(CuentaDto dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow();
        Cuenta cuenta = Cuenta.builder()
                .numeroCuenta(dto.getNumeroCuenta())
                .tipo(dto.getTipo())
                .saldoInicial(dto.getSaldoInicial())
                .estado(dto.getEstado())
                .cliente(cliente)
                .build();
        return mapToDto(cuentaRepository.save(cuenta));
    }

    @Override
    public CuentaDto actualizar(Long numeroCuenta, CuentaDto dto) {
        Cuenta cuenta = cuentaRepository.findById(numeroCuenta).orElseThrow();
        cuenta.setTipo(dto.getTipo());
        cuenta.setSaldoInicial(dto.getSaldoInicial());
        cuenta.setEstado(dto.getEstado());
        return mapToDto(cuentaRepository.save(cuenta));
    }

    @Override
    public CuentaDto obtenerPorNumero(Long numeroCuenta) {
        return cuentaRepository.findById(numeroCuenta)
                .map(this::mapToDto)
                .orElseThrow();
    }

    @Override
    public List<CuentaDto> listar() {
        return cuentaRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private CuentaDto mapToDto(Cuenta cuenta) {
        return CuentaDto.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipo(cuenta.getTipo())
                .saldoInicial(cuenta.getSaldoInicial())
                .estado(cuenta.getEstado())
                .clienteId(cuenta.getCliente().getClienteId())
                .build();
    }

}
