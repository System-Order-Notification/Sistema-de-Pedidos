package br.com.sp.pedidos.services.conversion;

import br.com.sp.pedidoDTOS.input.InputPedidoDTO;
import br.com.sp.pedidoDTOS.output.OutputPedidoDTO;
import br.com.sp.pedidos.domain.pedido.Pedido;

public interface ModelMapperService {

	OutputPedidoDTO convertPedidoToPedidoDTO(Pedido pedido);

	Pedido convertInputPedidoToPedido(InputPedidoDTO pedidoDTO);

}
