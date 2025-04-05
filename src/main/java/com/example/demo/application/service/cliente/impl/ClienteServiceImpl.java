package com.example.demo.application.service.cliente.impl;

import com.example.demo.application.service.cliente.ClienteService;
import com.example.demo.infrastructure.dao.cliente.ClienteDao;
import com.example.demo.infrastructure.dto.ClienteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteDao clienteDao;

    @Override
    public ClienteDto crear(ClienteDto dto) {
        return clienteDao.guardarCliente(dto);
    }

    @Override
    public ClienteDto actualizar(Long id, ClienteDto dto) {
        return clienteDao.actualizarCliente(id, dto);
    }

    @Override
    public ClienteDto obtener(Long id) {
        return clienteDao.obtenerClientePorId(id);
    }

    @Override
    public List<ClienteDto> listar() {
        return clienteDao.listarClientes();
    }

    @Override
    public void eliminar(Long id) {
        clienteDao.eliminarCliente(id);
    }

}
