package com.example.demo.application.service.persona.impl;

import com.example.demo.application.service.persona.PersonaService;
import com.example.demo.infrastructure.dao.persona.PersonaDao;
import com.example.demo.infrastructure.dto.PersonaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDao personaDao;

    @Override
    public PersonaDto crear(PersonaDto dto) {
        return personaDao.guardar(dto);
    }

    @Override
    public PersonaDto actualizar(Long id, PersonaDto dto) {
        return personaDao.actualizar(id, dto);
    }

    @Override
    public PersonaDto obtener(Long id) {
        return personaDao.obtenerPorId(id);
    }

    @Override
    public List<PersonaDto> listar() {
        return personaDao.listar();
    }

    @Override
    public void eliminar(Long id) {
        personaDao.eliminar(id);
    }

}
