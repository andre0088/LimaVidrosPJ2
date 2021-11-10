package com.limaVidros.gerenciamento.infrastructure.converter.modelMapper.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ModelMapperService {

	<T> T convert(Object data, Class<T> type);
	
	<S, T> List<T> mapList(List<S> source, Class<T> targetClass);
	
}
