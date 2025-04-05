package com.example.demo.infrastructure.dao.cliente;

import com.example.demo.infrastructure.dto.ClienteDto;

import java.util.List;

public interface ClienteDao {

    ClienteDto guardarCliente(ClienteDto clienteDto);
    ClienteDto actualizarCliente(Long id, ClienteDto clienteDto);
    ClienteDto obtenerClientePorId(Long id);
    List<ClienteDto> listarClientes();
    void eliminarCliente(Long id);

}
