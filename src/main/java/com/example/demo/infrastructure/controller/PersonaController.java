package com.example.demo.infrastructure.controller;

import com.example.demo.application.service.persona.PersonaService;
import com.example.demo.infrastructure.dto.PersonaDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Personas", description = "API para gestión de personas")
@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaDto> crear(@RequestBody PersonaDto dto) {
        return ResponseEntity.ok(personaService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<PersonaDto>> listar() {
        return ResponseEntity.ok(personaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDto> actualizar(@PathVariable Long id, @RequestBody PersonaDto dto) {
        return ResponseEntity.ok(personaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
