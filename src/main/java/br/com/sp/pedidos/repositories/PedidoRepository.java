package br.com.sp.pedidos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sp.pedidos.domain.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

}
