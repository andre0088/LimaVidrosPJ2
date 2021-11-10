package com.limaVidros.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.limaVidros.gerenciamento.domain.exception.IdExistenteException;
import com.limaVidros.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.limaVidros.gerenciamento.domain.exception.LoginInvalidoException;
import com.limaVidros.gerenciamento.domain.model.Funcionario.Funcionario;

@Service
public interface FuncionarioService {
	
	public Funcionario login(Funcionario funcionario) throws LoginInvalidoException;
	
	public Funcionario cadastrar(Funcionario funcionario) throws IdExistenteException;
	
	public Funcionario editar(String cpf, Funcionario funcionario) throws IdNaoEncontradoException;
	
	public void excluir(String cpf) throws IdNaoEncontradoException;
	
	public List<Funcionario> listar();
	
	public Funcionario buscarPorCPF(String cpf);
	
	public Funcionario buscarPorLogin(String cpf);
}
