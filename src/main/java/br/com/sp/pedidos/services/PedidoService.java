package br.com.sp.pedidos.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.sp.pedidoDTOS.output.OutputPedidoDTO;

public interface PedidoService {

	Page<OutputPedidoDTO> listAllActived(Pageable pageable);

	Page<OutputPedidoDTO> listAllInactived(Pageable pageable);

	Page<OutputPedidoDTO> listMyOrders(UUID userID, Pageable pageable);

}
