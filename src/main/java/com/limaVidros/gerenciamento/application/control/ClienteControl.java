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

import com.limaVidros.gerenciamento.domain.model.cliente.Cliente;
import com.limaVidros.gerenciamento.domain.service.ClienteService;
import com.limaVidros.gerenciamento.infrastructure.converter.modelMapper.service.ModelMapperService;
import com.limaVidros.gerenciamento.presentation.dto.cliente.ClienteRequest;
import com.limaVidros.gerenciamento.presentation.dto.cliente.ClienteResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/clientes")
@Api(value = "API REST Clientes")
@CrossOrigin(origins = "*")
public class ClienteControl {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<ClienteResponse> listar(){
		return modelMapper.mapList(clienteService.listar(), ClienteResponse.class);
	}
	
	@GetMapping("/{cpf}")
	public ClienteResponse listarPorCpf(@PathVariable(value="cpf")String cpf){
		Cliente c = null;
		try {
			c = clienteService.buscarPorCPF(cpf);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(c, ClienteResponse.class);
	}
	
	@PostMapping
	public ClienteResponse cadastrar(@RequestBody ClienteRequest clienteRequest) {
		Cliente c = null;
		try {
			c = clienteService.cadastrar(modelMapper.convert(clienteRequest, Cliente.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.convert(c, ClienteResponse.class);
	}
	
	@DeleteMapping("/{cpf}")
	public void deletar(@PathVariable(value="cpf")String cpf) {
		try {
			clienteService.excluir(cpf);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{cpf}")
	public ClienteResponse editar(@PathVariable(value="cpf")String cpf,@RequestBody ClienteRequest clienteRequest) {
		Cliente c = null;
		
		try {
			c = clienteService.editar(cpf, modelMapper.convert(clienteRequest, Cliente.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(c, ClienteResponse.class);
	}

}
