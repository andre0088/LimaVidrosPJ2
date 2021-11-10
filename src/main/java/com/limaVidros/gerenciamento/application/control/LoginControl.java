package com.limaVidros.gerenciamento.application.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limaVidros.gerenciamento.domain.exception.LoginInvalidoException;
import com.limaVidros.gerenciamento.domain.model.Funcionario.Funcionario;
import com.limaVidros.gerenciamento.domain.service.FuncionarioService;
import com.limaVidros.gerenciamento.infrastructure.converter.modelMapper.service.ModelMapperService;
import com.limaVidros.gerenciamento.presentation.dto.funcionario.FuncionarioRequest;
import com.limaVidros.gerenciamento.presentation.dto.funcionario.FuncionarioResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/login")
@Api(value = "API REST login")
@CrossOrigin(origins = "*")
public class LoginControl {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@PostMapping
	public ResponseEntity<FuncionarioResponse> login(@RequestBody FuncionarioRequest funcionarioRequest) {
		
		Funcionario f = null;
		try {
			f = funcionarioService.login(modelMapper.convert(funcionarioRequest, Funcionario.class));
		} catch (LoginInvalidoException e) {
			return new ResponseEntity(null,HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity(modelMapper.convert(f, FuncionarioResponse.class),HttpStatus.OK);
	}
	
}
