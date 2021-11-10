package com.limaVidros.gerenciamento.application.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limaVidros.gerenciamento.domain.model.Funcionario.Funcionario;
import com.limaVidros.gerenciamento.domain.service.FuncionarioService;
import com.limaVidros.gerenciamento.infrastructure.converter.modelMapper.service.ModelMapperService;
import com.limaVidros.gerenciamento.presentation.dto.funcionario.FuncionarioRequest;
import com.limaVidros.gerenciamento.presentation.dto.funcionario.FuncionarioResponse;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value="/funcionarios")
@Api(value = "API REST Funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioControl {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<FuncionarioResponse> listar(){
		return modelMapper.mapList(funcionarioService.listar(), FuncionarioResponse.class);
	}
	
	@GetMapping("/{cpf}")
	public FuncionarioResponse listarPorCpf(@PathVariable(value="cpf")String cpf){
		Funcionario f = null;
		try {
			f = funcionarioService.buscarPorCPF(cpf);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(f, FuncionarioResponse.class);
	}
	
	@PostMapping
	public FuncionarioResponse cadastrar(@RequestBody FuncionarioRequest funcionarioRequest) {
		Funcionario f = null;
		try {
			f = funcionarioService.cadastrar(modelMapper.convert(funcionarioRequest, Funcionario.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.convert(f, FuncionarioResponse.class);
	}
	
	@DeleteMapping("/{cpf}")
	public void deletar(@PathVariable(value="cpf")String cpf) {
		try {
			funcionarioService.excluir(cpf);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{cpf}")
	public FuncionarioResponse editar(@PathVariable(value="cpf")String cpf,@RequestBody FuncionarioRequest funcionarioRequest) {
		Funcionario f = null;
		
		try {
			f = funcionarioService.editar(cpf, modelMapper.convert(funcionarioRequest, Funcionario.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(f, FuncionarioResponse.class);
	}
	
}
