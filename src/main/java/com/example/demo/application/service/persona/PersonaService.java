package com.example.demo.application.service.persona;

import com.example.demo.infrastructure.dto.PersonaDto;

import java.util.List;

public interface PersonaService {

    PersonaDto crear(PersonaDto dto);
    PersonaDto actualizar(Long id, PersonaDto dto);
    PersonaDto obtener(Long id);
    List<PersonaDto> listar();
    void eliminar(Long id);

}
