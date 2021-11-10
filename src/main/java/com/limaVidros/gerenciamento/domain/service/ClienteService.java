package com.limaVidros.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.limaVidros.gerenciamento.domain.exception.IdExistenteException;
import com.limaVidros.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.limaVidros.gerenciamento.domain.model.cliente.Cliente;

@Service
public interface ClienteService {

public Cliente cadastrar(Cliente cliente) throws IdExistenteException;
	
	public Cliente editar(String cpf, Cliente cliente) throws IdNaoEncontradoException;
	
	public void excluir(String cpf) throws IdNaoEncontradoException;
	
	public List<Cliente> listar();
	
	public Cliente buscarPorCPF(String cpf);
	
}
