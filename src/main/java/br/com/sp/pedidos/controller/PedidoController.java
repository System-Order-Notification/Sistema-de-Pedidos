package br.com.sp.pedidos.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sp.pedidoDTOS.output.OutputPedidoDTO;
import br.com.sp.pedidos.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/listAllActived")
	public Page<OutputPedidoDTO> listAllPedidosActive(Pageable pageable) {
		return pedidoService.listAllActived(pageable);
	}
	
	@GetMapping("/listMyOrders/{userID}")
	public Page<OutputPedidoDTO> listMyPedidos(@PathVariable("userID") UUID userID, Pageable pageable) {
		return pedidoService.listMyOrders(userID, pageable);
	}
	
	@GetMapping("/listAllInactived")
	public Page<OutputPedidoDTO> listPedidosInactived(Pageable pageable) {
		return pedidoService.listAllInactived(pageable);
	}
	
	@PostMapping("/save")
	public void save() {
		
	}
	
	@PutMapping("/update")
	public void delete() {
		
	}
	
}
