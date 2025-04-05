package com.example.demo.infrastructure.dao.persona;

import com.example.demo.infrastructure.dto.PersonaDto;

import java.util.List;

public interface PersonaDao {

    PersonaDto guardar(PersonaDto personaDto);
    PersonaDto actualizar(Long id, PersonaDto personaDto);
    PersonaDto obtenerPorId(Long id);
    List<PersonaDto> listar();
    void eliminar(Long id);

}
