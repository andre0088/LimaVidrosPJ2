package com.limaVidros.gerenciamento.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.limaVidros.gerenciamento.domain.model.cliente.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
