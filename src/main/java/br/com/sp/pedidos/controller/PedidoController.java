package br.com.sp.pedidos.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sp.pedidoDTOS.input.InputPedidoDTO;
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
	public ResponseEntity<OutputPedidoDTO> save(@RequestBody InputPedidoDTO pedidoDTO, UriComponentsBuilder uriBuilder) {
		OutputPedidoDTO outputPedidoDTO = pedidoService.save(pedidoDTO);
		
		URI uri = uriBuilder.path("/api/pedidos/listMyOrders/{userID}").buildAndExpand(outputPedidoDTO.getUsuario().getId()).toUri();
		return ResponseEntity.created(uri).body(outputPedidoDTO);
	}
	
	@PutMapping("/update")
	public void delete() {
		
	}
	
}
