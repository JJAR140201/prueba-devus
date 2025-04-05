package com.example.demo.infrastructure.dao.cliente.impl;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Persona;
import com.example.demo.infrastructure.dao.cliente.ClienteDao;
import com.example.demo.infrastructure.dto.ClienteDto;
import com.example.demo.infrastructure.repository.ClienteRepository;
import com.example.demo.infrastructure.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ClienteDaoImpl implements ClienteDao {

    private final ClienteRepository clienteRepository;
    private final PersonaRepository personaRepository;

    @Override
    public ClienteDto guardarCliente(ClienteDto dto) {
        Persona persona = Persona.builder()
                .nombre(dto.getNombre())
                .genero(dto.getGenero())
                .edad(dto.getEdad())
                .identificacion(dto.getIdentificacion())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .build();

        persona = personaRepository.save(persona);

        Cliente cliente = Cliente.builder()
                .persona(persona)
                .contrasena(dto.getContrasena())
                .estado(dto.getEstado())
                .build();

        Cliente saved = clienteRepository.save(cliente);
        return mapToDto(saved);
    }

    @Override
    public ClienteDto actualizarCliente(Long id, ClienteDto dto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.getPersona().setNombre(dto.getNombre());
        cliente.getPersona().setGenero(dto.getGenero());
        cliente.getPersona().setEdad(dto.getEdad());
        cliente.getPersona().setIdentificacion(dto.getIdentificacion());
        cliente.getPersona().setDireccion(dto.getDireccion());
        cliente.getPersona().setTelefono(dto.getTelefono());
        cliente.setContrasena(dto.getContrasena());
        cliente.setEstado(dto.getEstado());

        return mapToDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto obtenerClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return mapToDto(cliente);
    }

    @Override
    public List<ClienteDto> listarClientes() {
        return clienteRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    private ClienteDto mapToDto(Cliente cliente) {
        Persona p = cliente.getPersona();
        return ClienteDto.builder()
                .id(cliente.getClienteId())
                .nombre(p.getNombre())
                .genero(p.getGenero())
                .edad(p.getEdad())
                .identificacion(p.getIdentificacion())
                .direccion(p.getDireccion())
                .telefono(p.getTelefono())
                .contrasena(cliente.getContrasena())
                .estado(cliente.getEstado())
                .build();
    }

}
