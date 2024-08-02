package br.com.sp.pedidos.services.conversion.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.sp.pedidoDTOS.output.OutputPedidoDTO;
import br.com.sp.pedidos.domain.pedido.Pedido;
import br.com.sp.pedidos.services.conversion.ModelMapperService;

@Service
public class ModelMapperServiceImpl implements ModelMapperService{
	
	private final ModelMapper modelMapper;

	public ModelMapperServiceImpl(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public OutputPedidoDTO convertPedidoToPedidoDTO(Pedido pedido) {
		return modelMapper.map(pedido, OutputPedidoDTO.class);
	}

}
