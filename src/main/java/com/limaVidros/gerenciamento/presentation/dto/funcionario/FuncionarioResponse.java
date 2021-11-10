package com.limaVidros.gerenciamento.presentation.dto.funcionario;

import java.math.BigDecimal;

import com.limaVidros.gerenciamento.domain.model.Endereco;
import com.limaVidros.gerenciamento.domain.model.Funcionario.Cargo;

public class FuncionarioResponse {

private String cpf;
	
	private String nome;
	
	private BigDecimal salario;
	
	private Endereco endereco;
	
	private String telefone;
	
	private String login;
	
	private Cargo cargo;
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	private String email;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
