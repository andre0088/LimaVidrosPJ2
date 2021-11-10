package com.limaVidros.gerenciamento.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limaVidros.gerenciamento.domain.exception.IdExistenteException;
import com.limaVidros.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.limaVidros.gerenciamento.domain.model.cliente.Cliente;
import com.limaVidros.gerenciamento.domain.service.ClienteService;
import com.limaVidros.gerenciamento.infrastructure.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente cadastrar(Cliente cliente) throws IdExistenteException {
		if(buscarPorCPF(cliente.getCpf()) !=null) {
			throw new IdExistenteException();
		}
		
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente editar(String cpf, Cliente cliente) throws IdNaoEncontradoException {
		Cliente c = null;
		
		if(buscarPorCPF(cpf)!=null) {
			cliente.setCpf(cpf);
			c = clienteRepository.save(cliente);
		}else {
			throw new IdNaoEncontradoException();
		}
		return c;
	}
	

	@Override
	public void excluir(String cpf) throws IdNaoEncontradoException {
		Cliente cliente = buscarPorCPF(cpf);
		
		if(cliente == null) {
			throw new IdNaoEncontradoException();
		}
		clienteRepository.deleteById(cpf);
		
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorCPF(String cpf){
		Cliente cliente = null;
		List<Cliente> clientes = clienteRepository.findAll();
		if(!clientes.isEmpty()) {
			for(Cliente c: clientes) {
				if(c.getCpf().equals(cpf)) {
					cliente = c;
					break;
				}
			}
		
		}
		
		return cliente;
	}
	
}
