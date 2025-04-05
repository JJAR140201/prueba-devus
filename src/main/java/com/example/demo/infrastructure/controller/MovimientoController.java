package com.example.demo.infrastructure.controller;

import com.example.demo.application.service.movimiento.MovimientoService;
import com.example.demo.infrastructure.dto.MovimientoDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Movimientos", description = "API para registrar y consultar movimientos")
@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<MovimientoDto> registrar(@RequestBody MovimientoDto dto) {
        return ResponseEntity.ok(movimientoService.registrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<MovimientoDto>> listar() {
        return ResponseEntity.ok(movimientoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.obtener(id));
    }

}
