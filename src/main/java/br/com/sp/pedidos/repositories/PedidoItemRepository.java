package br.com.sp.pedidos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sp.pedidos.domain.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, UUID>{

}
