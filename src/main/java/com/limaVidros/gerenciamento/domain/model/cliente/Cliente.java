package com.limaVidros.gerenciamento.domain.model.cliente;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.limaVidros.gerenciamento.domain.model.Endereco;
import com.sun.istack.NotNull;

@Entity
public class Cliente {

	public Cliente (){};
	
	@Id
	private String cpf;
	
	@Embedded
	@NotNull
	private Endereco endereco;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String telefone;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
