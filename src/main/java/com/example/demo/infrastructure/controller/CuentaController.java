package com.example.demo.infrastructure.controller;

import com.example.demo.application.service.cuenta.CuentaService;
import com.example.demo.infrastructure.dto.CuentaDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cuentas", description = "API para gestión de cuentas")
@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<CuentaDto> crear(@RequestBody CuentaDto dto) {
        return ResponseEntity.ok(cuentaService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<CuentaDto>> listar() {
        return ResponseEntity.ok(cuentaService.listar());
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaDto> obtener(@PathVariable Long numeroCuenta) {
        return ResponseEntity.ok(cuentaService.obtener(numeroCuenta));
    }

    @PutMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaDto> actualizar(@PathVariable Long numeroCuenta, @RequestBody CuentaDto dto) {
        return ResponseEntity.ok(cuentaService.actualizar(numeroCuenta, dto));
    }

}
