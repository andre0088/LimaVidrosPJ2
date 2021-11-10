package com.limaVidros.gerenciamento.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limaVidros.gerenciamento.domain.exception.IdExistenteException;
import com.limaVidros.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.limaVidros.gerenciamento.domain.exception.LoginInvalidoException;
import com.limaVidros.gerenciamento.domain.model.Funcionario.Funcionario;
import com.limaVidros.gerenciamento.domain.service.FuncionarioService;
import com.limaVidros.gerenciamento.infrastructure.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImp implements FuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario cadastrar(Funcionario funcionario) throws IdExistenteException {
		if(buscarPorCPF(funcionario.getCpf()) !=null) {
			throw new IdExistenteException();
		}
		
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Funcionario editar(String cpf, Funcionario funcionario) throws IdNaoEncontradoException {
		Funcionario f = null;
		
		if(buscarPorCPF(cpf)!=null) {
			funcionario.setCpf(cpf);
			f = funcionarioRepository.save(funcionario);
		}else {
			throw new IdNaoEncontradoException();
		}
		return f;
	}
	

	@Override
	public void excluir(String cpf) throws IdNaoEncontradoException {
		Funcionario funcionario = buscarPorCPF(cpf);
		
		if(funcionario == null) {
			throw new IdNaoEncontradoException();
		}
		funcionarioRepository.deleteById(cpf);
		
	}

	@Override
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Funcionario buscarPorCPF(String cpf){
		Funcionario funcionario = null;
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		if(!funcionarios.isEmpty()) {
			for(Funcionario f: funcionarios) {
				if(f.getCpf().equals(cpf)) {
					funcionario = f;
					break;
				}
			}
		
		}
		
		return funcionario;
	}
	
	@Override
	public Funcionario buscarPorLogin(String login){
		Funcionario funcionario = null;
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		if(!funcionarios.isEmpty()) {
			for(Funcionario f: funcionarios) {
				if(f.getLogin().equals(login)) {
					funcionario = f;
					break;
				}
			}
		
		}
		
		return funcionario;
	}

	@Override
	public Funcionario login(Funcionario funcionario) throws LoginInvalidoException {
		Funcionario f =  null;
		f = buscarPorLogin(funcionario.getLogin());
		if(f == null || !f.getSenha().equals(funcionario.getSenha())) {
			throw new LoginInvalidoException();
		}
		
		return f;
		
	}

}
