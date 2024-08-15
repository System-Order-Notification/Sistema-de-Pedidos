package br.com.sp.pedidos.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sp.UsuarioDTOS.output.OutputUsuarioDTO;
import br.com.sp.pedidoDTOS.input.InputPedidoDTO;
import br.com.sp.pedidoDTOS.output.OutputPedidoDTO;
import br.com.sp.pedidos.data.UsuarioFeign;
import br.com.sp.pedidos.domain.PedidoItem;
import br.com.sp.pedidos.domain.pedido.Pedido;
import br.com.sp.pedidos.repositories.PedidoRepository;
import br.com.sp.pedidos.services.PedidoService;
import br.com.sp.pedidos.services.conversion.ModelMapperService;
import br.com.sp.pedidos.services.exceptions.UuidNotFoundException;
import feign.FeignException;
import jakarta.transaction.Transactional;

@Service
public class PedidoServiceImpl implements PedidoService{
	private final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);
	
	private final Environment env;
	private final PedidoRepository pedidoRepository;
	private final ModelMapperService modelMapperService;
	private final UsuarioFeign usuarioFeign;

	public PedidoServiceImpl(PedidoRepository pedidoRepository, ModelMapperService modelMapperService, UsuarioFeign usuarioFeign, 
			Environment env) {
		super();
		this.env = env;
		this.pedidoRepository = pedidoRepository;
		this.modelMapperService = modelMapperService;
		this.usuarioFeign = usuarioFeign;
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
	
	
	/*
	 * valorTotal: multiplicação do valor do produto com a quantidade
	 * valorTotalGeral: soma do valorTotal com o valor do frete
	 */
	@Override
	@Transactional
	public OutputPedidoDTO save(InputPedidoDTO pedidoDTO) {
		Pedido pedido = modelMapperService.convertInputPedidoToPedido(pedidoDTO);
		
		List<PedidoItem> pedidoItens = pedido.getItens();
		Float valorTotal = 0f;
		
		for (PedidoItem pedidoItem : pedidoItens) {
			valorTotal += pedidoItem.getValorUnitario() * pedidoItem.getQuantidade();
		}
		
		pedido.setValorTotal(valorTotal);
		pedido.setValorTotalGeral(valorTotal + pedido.getValorFrete());
		OutputUsuarioDTO outputUsuarioDTO = new OutputUsuarioDTO();
		
		try {
			logger.info("PEDIDO-SERVICE ::: Get Request on " + env.getProperty("local.server.port") + " port");
			outputUsuarioDTO = usuarioFeign.retornarEmpresa(pedidoDTO.getUserID()).getBody();
		} catch (FeignException e) {
			e.printStackTrace();
		}
		
		if (outputUsuarioDTO == null || outputUsuarioDTO != null && outputUsuarioDTO.getEnabled() == false)
			throw new UuidNotFoundException("UUID inválido ou inativado");
		
		pedido.setUserID(outputUsuarioDTO.getId());
		pedido = pedidoRepository.save(pedido);
		
		OutputPedidoDTO dto = modelMapperService.convertPedidoToPedidoDTO(pedido);
		dto.setUsuario(outputUsuarioDTO);
		return dto;
	}

}
