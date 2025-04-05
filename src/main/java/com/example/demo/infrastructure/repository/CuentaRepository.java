package com.example.demo.infrastructure.repository;

import com.example.demo.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
