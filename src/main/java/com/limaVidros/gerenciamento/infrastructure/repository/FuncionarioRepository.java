package com.limaVidros.gerenciamento.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.limaVidros.gerenciamento.domain.model.Funcionario.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String>{
	
}
