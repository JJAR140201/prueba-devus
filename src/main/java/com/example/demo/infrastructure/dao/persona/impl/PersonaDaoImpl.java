package com.example.demo.infrastructure.dao.persona.impl;

import com.example.demo.domain.Persona;
import com.example.demo.infrastructure.dao.persona.PersonaDao;
import com.example.demo.infrastructure.dto.PersonaDto;
import com.example.demo.infrastructure.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PersonaDaoImpl implements PersonaDao {

    private final PersonaRepository personaRepository;

    @Override
    public PersonaDto guardar(PersonaDto dto) {
        Persona persona = mapToEntity(dto);
        return mapToDto(personaRepository.save(persona));
    }

    @Override
    public PersonaDto actualizar(Long id, PersonaDto dto) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(dto.getNombre());
        persona.setGenero(dto.getGenero());
        persona.setEdad(dto.getEdad());
        persona.setIdentificacion(dto.getIdentificacion());
        persona.setDireccion(dto.getDireccion());
        persona.setTelefono(dto.getTelefono());

        return mapToDto(personaRepository.save(persona));
    }

    @Override
    public PersonaDto obtenerPorId(Long id) {
        return personaRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow();
    }

    @Override
    public List<PersonaDto> listar() {
        return personaRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }

    private Persona mapToEntity(PersonaDto dto) {
        return Persona.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .genero(dto.getGenero())
                .edad(dto.getEdad())
                .identificacion(dto.getIdentificacion())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .build();
    }

    private PersonaDto mapToDto(Persona persona) {
        return PersonaDto.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .genero(persona.getGenero())
                .edad(persona.getEdad())
                .identificacion(persona.getIdentificacion())
                .direccion(persona.getDireccion())
                .telefono(persona.getTelefono())
                .build();
    }

}
