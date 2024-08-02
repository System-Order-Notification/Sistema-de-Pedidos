package br.com.sp.pedidos.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sp.pedidoDTOS.output.OutputPedidoDTO;
import br.com.sp.pedidos.domain.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
	
	@Query("SELECT p FROM Pedido p WHERE p.actived = true")
	Page<Pedido> listAllActived(Pageable pageable);
	
	@Query("SELECT p FROM Pedido p WHERE p.actived = false")
	Page<Pedido> listAllInactived(Pageable pageable);
	
	@Query("SELECT p FROM Pedido p WHERE p.userID = :userID")
	Page<Pedido> listMyOrders(Pageable pageable, @Param("userID") UUID userID);


}
