package br.com.sp.pedidos.domain;

import java.util.UUID;

import br.com.sp.pedidos.domain.pedido.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PEDIDO_ITENS")
public class PedidoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String nomeEmpresa;
	private Float valorUnitario;
	private Integer quantidade;
	private String dataEntrega;
	
	@ManyToOne()
	private Pedido pedido;
	
	public PedidoItem() {
		// TODO Auto-generated constructor stub
	}

	public PedidoItem(String nomeEmpresa, Float valorUnitario, Integer quantidade, String dataEntrega, Pedido pedido) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.dataEntrega = dataEntrega;
		this.pedido = pedido;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
