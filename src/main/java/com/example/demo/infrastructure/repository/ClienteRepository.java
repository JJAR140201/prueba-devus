package com.example.demo.infrastructure.repository;

import com.example.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
