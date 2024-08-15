package br.com.sp.pedidos.data;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.sp.UsuarioDTOS.output.OutputUsuarioDTO;

@FeignClient(name = "service-usuario", url = "http://localhost:8000")
public interface UsuarioFeign {
	
	@GetMapping("/api/users/findOne/{id}")
	public ResponseEntity<OutputUsuarioDTO> retornarEmpresa(@PathVariable UUID id);
}
