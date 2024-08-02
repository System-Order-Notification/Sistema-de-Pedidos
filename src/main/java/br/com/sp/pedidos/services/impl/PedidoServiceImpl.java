package br.com.sp.pedidos.services.impl;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sp.pedidoDTOS.output.OutputPedidoDTO;
import br.com.sp.pedidos.repositories.PedidoRepository;
import br.com.sp.pedidos.services.PedidoService;
import br.com.sp.pedidos.services.conversion.ModelMapperService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	private final PedidoRepository pedidoRepository;
	private final ModelMapperService modelMapperService;

	public PedidoServiceImpl(PedidoRepository pedidoRepository, ModelMapperService modelMapperService) {
		super();
		this.pedidoRepository = pedidoRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Page<OutputPedidoDTO> listAllActived(Pageable pageable) {
		Page<OutputPedidoDTO> list = pedidoRepository.listAllActived(pageable).map(pedido -> modelMapperService.convertPedidoToPedidoDTO(pedido));
		
		return list;
	}
	
	@Override
	public Page<OutputPedidoDTO> listAllInactived(Pageable pageable) {
		Page<OutputPedidoDTO> list = pedidoRepository.listAllInactived(pageable).map(pedido -> modelMapperService.convertPedidoToPedidoDTO(pedido));
		
		return list;
	}
	
	@Override
	public Page<OutputPedidoDTO> listMyOrders(UUID userID, Pageable pageable) {
		Page<OutputPedidoDTO> list = pedidoRepository.listMyOrders(pageable, userID).map(pedido -> modelMapperService.convertPedidoToPedidoDTO(pedido));
		
		return list;
	}

}
