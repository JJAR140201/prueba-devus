package com.example.demo.infrastructure.dao.movimiento.impl;

import com.example.demo.domain.Cuenta;
import com.example.demo.domain.Movimiento;
import com.example.demo.infrastructure.dao.movimiento.MovimientoDao;
import com.example.demo.infrastructure.dto.MovimientoDto;
import com.example.demo.infrastructure.repository.CuentaRepository;
import com.example.demo.infrastructure.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MovimientoDaoImpl implements MovimientoDao {

    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    @Override
    public MovimientoDto registrarMovimiento(MovimientoDto dto) {
        Cuenta cuenta = cuentaRepository.findById(dto.getCuentaId()).orElseThrow();

        BigDecimal nuevoSaldo = cuenta.getSaldoInicial();
        BigDecimal valorMovimiento = dto.getValor();

        if ("Retiro".equalsIgnoreCase(dto.getTipoMovimiento())) {
            if (nuevoSaldo.compareTo(valorMovimiento) < 0) {
                throw new RuntimeException("Saldo no disponible");
            }
            nuevoSaldo = nuevoSaldo.subtract(valorMovimiento);
        } else {
            nuevoSaldo = nuevoSaldo.add(valorMovimiento);
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        Movimiento movimiento = Movimiento.builder()
                .cuenta(cuenta)
                .fecha(dto.getFecha() != null ? dto.getFecha() : LocalDate.now())
                .tipoMovimiento(dto.getTipoMovimiento())
                .valor(dto.getTipoMovimiento().equalsIgnoreCase("Retiro") ? valorMovimiento.negate() : valorMovimiento)
                .saldo(nuevoSaldo)
                .build();

        return mapToDto(movimientoRepository.save(movimiento));
    }

    @Override
    public MovimientoDto obtenerMovimiento(Long id) {
        return movimientoRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow();
    }

    @Override
    public List<MovimientoDto> listarMovimientos() {
        return movimientoRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private MovimientoDto mapToDto(Movimiento m) {
        return MovimientoDto.builder()
                .id(m.getId())
                .cuentaId(m.getCuenta().getNumeroCuenta())
                .fecha(m.getFecha())
                .tipoMovimiento(m.getTipoMovimiento())
                .valor(m.getValor())
                .saldo(m.getSaldo())
                .build();
    }

}
