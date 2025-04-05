package com.example.demo.infrastructure.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoDto {

    private Long id;
    private Long cuentaId;
    private LocalDate fecha;
    private String tipoMovimiento; // "Deposito" o "Retiro"
    private BigDecimal valor;
    private BigDecimal saldo;

}
