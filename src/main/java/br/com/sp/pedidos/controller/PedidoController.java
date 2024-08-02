package br.com.sp.pedidos.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public void listAllPedidosActive() {
		
	}
	
	@GetMapping("/listMyOrders/{userID}")
	public void listMyPedidos(UUID userID) {
		
	}
	
	@GetMapping("/listAllInactived")
	public void listPedidosInactived() {
		
	}
	
	@PostMapping("/save")
	public void save() {
		
	}
	
	@PutMapping("/update")
	public void delete() {
		
	}
	
}
