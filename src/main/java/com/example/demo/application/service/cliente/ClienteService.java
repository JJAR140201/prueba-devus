package com.example.demo.application.service.cliente;

import com.example.demo.infrastructure.dto.ClienteDto;

import java.util.List;

public interface ClienteService {

    ClienteDto crear(ClienteDto clienteDto);
    ClienteDto actualizar(Long id, ClienteDto clienteDto);
    ClienteDto obtener(Long id);
    List<ClienteDto> listar();
    void eliminar(Long id);

}
